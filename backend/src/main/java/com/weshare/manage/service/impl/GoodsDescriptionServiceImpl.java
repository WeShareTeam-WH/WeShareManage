package com.weshare.manage.service.impl;
import com.weshare.manage.entity.GoodsDescription;
import com.weshare.manage.service.GoodsDescriptionService;
import com.weshare.manage.repository.GoodsDescriptionRepository;
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
public class GoodsDescriptionServiceImpl implements GoodsDescriptionService {
	@Autowired
	private GoodsDescriptionRepository goodsDescriptionRepository;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public GoodsDescription add(GoodsDescription goodsDescription){
		return goodsDescriptionRepository.save(goodsDescription);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void delete(Long id){
		goodsDescriptionRepository.deleteById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public GoodsDescription update(GoodsDescription goodsDescription){
		return goodsDescriptionRepository.saveAndFlush(goodsDescription);
	}
	public GoodsDescription get(Long id){
		return goodsDescriptionRepository.getOne(id);
	}
	public List<GoodsDescription> getAll(){
		return goodsDescriptionRepository.findAll();
	}
	public Page<GoodsDescription> getPage(int page, int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		return goodsDescriptionRepository.findAll(pageable);
	}
}