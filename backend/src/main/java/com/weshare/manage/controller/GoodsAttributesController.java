package com.weshare.manage.controller;
import com.weshare.manage.entity.GoodsAttributes;
import com.weshare.manage.service.GoodsAttributesService;
import com.weshare.manage.cto.Result;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodsAttributes")
public class GoodsAttributesController {
	@Autowired
	private GoodsAttributesService goodsAttributesService;
	@RequestMapping(value = "/add", method = RequestMethod.POST )
	public @ResponseBody Result add(@RequestBody GoodsAttributes goodsAttributes){
		try{
			return Result.success(goodsAttributesService.add(goodsAttributes));
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE )
	public @ResponseBody Result delete(Long id){
		try{
			goodsAttributesService.delete(id);
			return Result.success();
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public @ResponseBody
	Result update(@RequestBody GoodsAttributes goodsAttributes){
		try{
			return Result.success(goodsAttributesService.update(goodsAttributes));
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody Result get(Long id){
		try{
			GoodsAttributes goodsAttributes = goodsAttributesService.get(id);
			if(goodsAttributes==null){throw new RuntimeException();}
			return Result.success(goodsAttributes);
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody Result getAll(){
		try{
			return Result.success(goodsAttributesService.getAll());
		}catch(Exception e){
			e.printStackTrace();
			return Result.failure(e.toString());
		}
	}
	@RequestMapping(value = "/getPage", method = RequestMethod.GET)
	public @ResponseBody Result getPage(int page, int rows){
		try{
			Page<GoodsAttributes> pageBean = goodsAttributesService.getPage(page,rows);
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