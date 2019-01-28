package com.weshare.manage.service.impl;
import com.weshare.manage.entity.AttributesSkuMapping;
import com.weshare.manage.entity.Goods;
import com.weshare.manage.entity.GoodsDetailModel;
import com.weshare.manage.entity.GoodsSku;
import com.weshare.manage.repository.GoodsRepository;
import com.weshare.manage.service.GoodsSkuService;
import com.weshare.manage.repository.GoodsSkuRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class GoodsSkuServiceImpl implements GoodsSkuService {
	@Autowired
	private GoodsSkuRepository goodsSkuRepository;

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public GoodsSku save(GoodsSku goodsSku){
		 return goodsSkuRepository.save(goodsSku);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void delete(Long id){
		goodsSkuRepository.deleteById(id);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public GoodsSku update(GoodsSku goodsSku){
		return goodsSkuRepository.saveAndFlush(goodsSku);
	}

	public GoodsSku get(Long id){
		return goodsSkuRepository.findById(id).get();
	}

	public List<GoodsSku> getAll(){
		return goodsSkuRepository.findAll();
	}

	public Page<GoodsSku> getPage(int page, int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		return goodsSkuRepository.findAll(pageable);
	}
}