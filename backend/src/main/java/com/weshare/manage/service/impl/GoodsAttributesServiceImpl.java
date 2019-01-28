package com.weshare.manage.service.impl;
import com.weshare.manage.entity.GoodsAttributes;
import com.weshare.manage.service.GoodsAttributesService;
import com.weshare.manage.repository.GoodsAttributesRepository;
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
public class GoodsAttributesServiceImpl implements GoodsAttributesService {
	@Autowired
	private GoodsAttributesRepository goodsAttributesRepository;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public GoodsAttributes add(GoodsAttributes goodsAttributes){
		return goodsAttributesRepository.save(goodsAttributes);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void delete(Long id){
		goodsAttributesRepository.deleteById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public GoodsAttributes update(GoodsAttributes goodsAttributes){
		return goodsAttributesRepository.saveAndFlush(goodsAttributes);
	}
	public GoodsAttributes get(Long id){
		return goodsAttributesRepository.findById(id).get();
	}
	public List<GoodsAttributes> getAll(){
		return goodsAttributesRepository.findAll();
	}
	public Page<GoodsAttributes> getPage(int page, int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		return goodsAttributesRepository.findAll(pageable);
	}
}