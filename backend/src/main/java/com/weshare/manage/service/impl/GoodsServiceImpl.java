package com.weshare.manage.service.impl;
import com.weshare.manage.entity.*;
import com.weshare.manage.repository.*;
import com.weshare.manage.service.GoodsService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.weshare.manage.service.GoodsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ExcludeSuperclassListeners;
import javax.persistence.Id;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsRepository goodsRepository;

	@Autowired
	private GoodsLabelRepository goodsLabelRepository;

	@Autowired
	private GoodsLabelMappingRespository goodsLabelMappingRespository;

	@Autowired
	private GoodsSkuRepository goodsSkuRepository;

	@Autowired
	private GoodsDescriptionRepository goodsDescriptionRepository;

	@Autowired
	private ImageTypeRespository  imageTypeRespository;

	public Goods findBasicGoodsById(Long id)
	{
		return goodsRepository.findById(id).get();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void addGoodsBasic(GoodsDetailModel goodsDetailModel) {
		if (goodsDetailModel != null) {
			if (goodsDetailModel.getGoods() != null) {
				goodsRepository.save(goodsDetailModel.getGoods());
			}
			if (goodsDetailModel.getGoodsLabels() != null) {
				for (GoodsLabel goodsLabel : goodsDetailModel.getGoodsLabels())
				{
					GoodsLabelMapping mapping = new GoodsLabelMapping();
					mapping.setGoodsId(goodsDetailModel.getGoods().getId());
					mapping.setGoodsLabelId(goodsLabel.getId());
					mapping.setAddTime(new Timestamp(new Date().getTime()));
					mapping.setDeleted(false);
					goodsLabelMappingRespository.save(mapping);
				}
			}
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void editGoodsBasic(GoodsDetailModel goodsDetailModel){
		if (goodsDetailModel != null) {
			// Update goods basic info.
			if (goodsDetailModel.getGoods() != null) {
				Goods updateGoods = goodsRepository.findById(goodsDetailModel.getGoods().getId()).get();
				updateGoods.setGoodsTitle(goodsDetailModel.getGoods().getGoodsTitle());
				updateGoods.setGoodsAddress(goodsDetailModel.getGoods().getGoodsAddress());
				updateGoods.setGoodsDescripe(goodsDetailModel.getGoods().getGoodsDescripe());
				updateGoods.setGoodsMateriel(goodsDetailModel.getGoods().getGoodsMateriel());
				updateGoods.setDeleted(goodsDetailModel.getGoods().getDeleted());
				updateGoods.setGoodsTypeId(goodsDetailModel.getGoods().getGoodsTypeId());
				updateGoods.setAddTime(new Timestamp(new Date().getTime()));
				goodsRepository.save(updateGoods);
			}
			// Update goods label info.
			if (goodsDetailModel.getGoodsLabels() != null) {
				List<GoodsLabelMapping> goodsLabelMappings = goodsLabelMappingRespository.queryAllByGoodsId(goodsDetailModel.getGoods().getId());
				List<GoodsLabelMapping> addedGoodsLabelMapping = new ArrayList<GoodsLabelMapping>();
				List<GoodsLabelMapping> deletedGoodsLabelMapping = new ArrayList<GoodsLabelMapping>();
				for (GoodsLabelMapping goodsLabelMapping : goodsLabelMappings)
				{
					boolean find = false;
					for (GoodsLabel goodsLabel : goodsDetailModel.getGoodsLabels())
					{
						if (goodsLabelMapping.getGoodsLabelId() == goodsLabel.getId())
						{
							find = true;
							break;
						}
					}
					if (!find)
					{
						deletedGoodsLabelMapping.add(goodsLabelMapping);
					}
				}

				for (GoodsLabel goodsLabel : goodsDetailModel.getGoodsLabels())
				{
					boolean find = true;
					for (GoodsLabelMapping goodsLabelMapping : goodsLabelMappings)
					{
						if (goodsLabelMapping.getGoodsLabelId() == goodsLabel.getId())
						{
							find = true;
							break;
						}
					}
					if (!find)
					{
						GoodsLabelMapping mapping = new GoodsLabelMapping();
						mapping.setGoodsId(goodsDetailModel.getGoods().getId());
						mapping.setGoodsLabelId(goodsLabel.getId());
						mapping.setAddTime(new Timestamp(new Date().getTime()));
						mapping.setDeleted(false);
						addedGoodsLabelMapping.add(mapping);
					}
				}

				goodsLabelMappingRespository.saveAll(addedGoodsLabelMapping);

				goodsLabelMappingRespository.deleteAll(deletedGoodsLabelMapping);
			}

			// Update goods image info.
			if (goodsDetailModel.getGoods().getGoodsImageUrl() != null && goodsDetailModel.getGoods().getGoodsImageUrl() != ""){
				ImageType type = imageTypeRespository.findById(1).get();
				GoodsDescription goodsDescription = goodsDescriptionRepository.findByGoodsByGoodsIdAndImageTypeByImageTypeId(goodsDetailModel.getGoods(), type);
				if (goodsDescription != null){
					goodsDescription.setImageUrl(goodsDetailModel.getGoods().getGoodsImageUrl());
					goodsDescription.setAddTime(new Timestamp(new Date().getTime()));
					goodsDescriptionRepository.save(goodsDescription);
				}
				else{
					GoodsDescription description = new GoodsDescription();
					description.setGoodsByGoodsId(goodsDetailModel.getGoods());
					description.setImageTypeByImageTypeId(type);
					description.setImageUrl(goodsDetailModel.getGoods().getGoodsImageUrl());
					description.setAddTime(new Timestamp(new Date().getTime()));
					description.setDeleted(false);
					goodsDescriptionRepository.save(description);
				}
			}
		}
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void addGoodsDescription(GoodsDetailModel goodsDetailModel) {

	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void delete(Long id){
		goodsRepository.deleteById(id);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public Goods update(Goods goods){
		return goodsRepository.saveAndFlush(goods);
	}

	public GoodsDetailModel get(Long id){
		GoodsDetailModel goodsDetailModel = null;
		Goods goods = goodsRepository.getOne(id);
		if (goods != null)
		{
			goodsDetailModel = new GoodsDetailModel();
			goodsDetailModel.setGoods(goods);
			List<GoodsLabel> goodsLabels = goodsLabelRepository.queryAllByGoodsId(goods.getId());
			if (goodsLabels != null)
			{
				goodsDetailModel.setGoodsLabels(goodsLabels);
			}
			List<GoodsSku> skus = goodsSkuRepository.findByGoodsByGoodsId(goods);
			if (skus != null)
			{
				goodsDetailModel.setGoodsSkus(skus);
			}
			List<GoodsDescription> descriptions = goodsDescriptionRepository.findByGoodsByGoodsId(goods);
			if (descriptions != null)
			{
				for (GoodsDescription goodsDescription : descriptions)
				{
					if (goodsDescription.getImageTypeByImageTypeId() != null && goodsDescription.getImageTypeByImageTypeId().getId() == 1)
					{
						goods.setGoodsImageUrl(goodsDescription.getImageUrl());
					}
				}
				goodsDetailModel.setGoodsDescriptions(descriptions);
			}
		}
		return goodsDetailModel;
	}

	public List<Goods> getAll(){
		return goodsRepository.findAll();
	}

	public Page<Goods> getPage(int page, int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		return goodsRepository.findAll(pageable);
	}
}