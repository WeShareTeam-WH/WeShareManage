package com.weshare.manage.controller;
import com.weshare.manage.entity.*;
import com.weshare.manage.service.AttributeSkuMappingsService;
import com.weshare.manage.service.GoodsAttributesService;
import com.weshare.manage.service.GoodsService;
import com.weshare.manage.service.GoodsSkuService;
import com.weshare.manage.cto.Result;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.weshare.manage.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodsSku")
public class GoodsSkuController {
	@Autowired
	private GoodsSkuService goodsSkuService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private AttributeSkuMappingsService attributeSkuMappingsService;

	@Autowired
	private GoodsAttributesService goodsAttributesService;


	@RequestMapping(value = "/goodsSku", method = RequestMethod.POST)
	public @ResponseBody Result addOrUpdateGoodsSku(@RequestBody GoodsDetailModel goodsDetailModel){
		try{
			if (goodsDetailModel != null && goodsDetailModel.getGoodsSkus() != null)
			{
				List<GoodsSku> goodsSkus = goodsDetailModel.getGoodsSkus();
				Goods goods = goodsService.findBasicGoodsById(goodsDetailModel.getGoods().getId());
				if (goods != null && goodsSkus != null)
				{
					for (GoodsSku goodsSku : goodsSkus)
					{
						goodsSku.setGoodsByGoodsId(goods);
						if (goodsSku.getBase64Image() != null && goodsSku.getBase64Image() != "")
						{
							String imagePath = ImageUtil.GenerateImage(goodsSku.getBase64Image());
							goodsSku.setUrl(imagePath);
						}

						if (goodsSku.getBase64Image() != null && goodsSku.getBase64Image() != "")
						{
							goodsSku.setBase64Image("");
						}

						// Add goods
						if (goodsSku.getId() == 0){
							List<AttributesSkuMapping> attributesSkuMappings = goodsSku.getAttributeSkuMappings();
							goodsSku.setAttributeSkuMappings(null);
							goodsSku = goodsSkuService.save(goodsSku);

							for (AttributesSkuMapping mapping : attributesSkuMappings)
							{
								GoodsAttributes goodsAttributes = goodsAttributesService.get(mapping.getGoodsAttributes().getId());
								mapping.setGoodsAttributes(goodsAttributes);
								mapping.setGoodsSku(goodsSku);
							}
							attributeSkuMappingsService.save(attributesSkuMappings);
							goodsSku.setAttributeSkuMappings(attributesSkuMappings);
						}
						// Delete sku
						else if (goodsSku.getCancel()){
							List<AttributesSkuMapping> attributesSkuMappings = goodsSku.getAttributeSkuMappings();
							attributeSkuMappingsService.delete(attributesSkuMappings);
							goodsSkuService.delete(goodsSku.getId());
						}
						//Edit sku
						else{
							GoodsSku dbSku = goodsSkuService.get(goodsSku.getId());
							dbSku.setUrl(goodsSku.getUrl());
							dbSku.setAvaliableNum(dbSku.getAvaliableNum());
							dbSku.setUnitPrice(goodsSku.getUnitPrice());
							goodsSkuService.save(dbSku);
							List<AttributesSkuMapping> attributesSkuMappings = goodsSku.getAttributeSkuMappings();
							for (AttributesSkuMapping mapping : attributesSkuMappings)
							{
								AttributesSkuMapping dbMapping = attributeSkuMappingsService.get(mapping.getId());
								GoodsAttributes goodsAttributes = goodsAttributesService.get(mapping.getGoodsAttributes().getId());
								if (dbMapping != null && goodsAttributes != null)
								{
									dbMapping.setGoodsSku(dbSku);
									dbMapping.setAddTime(new Timestamp(new Date().getTime()));
									dbMapping.setValue(mapping.getValue());
									dbMapping.setGoodsAttributes(goodsAttributes);
								}
							}
						}
					}
				}
				goodsDetailModel = goodsService.get(goods.getId());
			}
			return Result.success(goodsDetailModel);
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE )
	public @ResponseBody Result delete(Long id){
		try{
			goodsSkuService.delete(id);
			return Result.success();
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public @ResponseBody Result update(@RequestBody GoodsSku goodsSku){
		try{
			return Result.success(goodsSkuService.update(goodsSku));
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody Result get(Long id){
		try{
			GoodsSku goodsSku = goodsSkuService.get(id);
			if(goodsSku==null){throw new RuntimeException();}
			return Result.success(goodsSku);
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody Result getAll(){
		try{
			return Result.success(goodsSkuService.getAll());
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/getPage", method = RequestMethod.GET)
	public @ResponseBody Result getPage(int page, int rows){
		try{
			Page<GoodsSku> pageBean = goodsSkuService.getPage(page,rows);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("total",pageBean.getTotalElements());
			result.put("rows",pageBean.getContent());
			return Result.success(result);
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
}