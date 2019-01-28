package com.weshare.manage.service.impl;
import com.weshare.manage.entity.GoodsType;
import com.weshare.manage.service.GoodsTypeService;
import com.weshare.manage.repository.GoodsTypeRepository;
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
public class GoodsTypeServiceImpl implements GoodsTypeService {
	@Autowired
	private GoodsTypeRepository goodsTypeRepository;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public GoodsType add(GoodsType goodsType){
		return goodsTypeRepository.save(goodsType);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void delete(Long id){
		goodsTypeRepository.deleteById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public GoodsType update(GoodsType goodsType){
		return goodsTypeRepository.saveAndFlush(goodsType);
	}
	public GoodsType get(Long id){
		return goodsTypeRepository.getOne(id);
	}
	public List<GoodsType> getAll(){
		return goodsTypeRepository.findAll();
	}
	public Page<GoodsType> getPage(int page, int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		return goodsTypeRepository.findAll(pageable);
	}
}