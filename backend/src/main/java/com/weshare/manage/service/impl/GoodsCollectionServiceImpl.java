package com.weshare.manage.service.impl;
import com.weshare.manage.entity.GoodsCollection;
import com.weshare.manage.service.GoodsCollectionService;
import com.weshare.manage.repository.GoodsCollectionRepository;
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
public class GoodsCollectionServiceImpl implements GoodsCollectionService {
	@Autowired
	private GoodsCollectionRepository goodsCollectionRepository;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public GoodsCollection add(GoodsCollection goodsCollection){
		return goodsCollectionRepository.save(goodsCollection);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void delete(Long id){
		goodsCollectionRepository.deleteById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public GoodsCollection update(GoodsCollection goodsCollection){
		return goodsCollectionRepository.saveAndFlush(goodsCollection);
	}
	public GoodsCollection get(Long id){
		return goodsCollectionRepository.getOne(id);
	}
	public List<GoodsCollection> getAll(){
		return goodsCollectionRepository.findAll();
	}
	public Page<GoodsCollection> getPage(int page, int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		return goodsCollectionRepository.findAll(pageable);
	}
}