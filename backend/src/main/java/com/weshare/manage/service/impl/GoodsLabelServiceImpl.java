package com.weshare.manage.service.impl;
import com.weshare.manage.entity.GoodsLabel;
import com.weshare.manage.service.GoodsLabelService;
import com.weshare.manage.repository.GoodsLabelRepository;
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
public class GoodsLabelServiceImpl implements GoodsLabelService {
	@Autowired
	private GoodsLabelRepository goodsLabelRepository;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public GoodsLabel add(GoodsLabel goodsLabel){
		return goodsLabelRepository.save(goodsLabel);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void delete(Long id){
		goodsLabelRepository.deleteById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public GoodsLabel update(GoodsLabel goodsLabel){
		return goodsLabelRepository.saveAndFlush(goodsLabel);
	}
	public GoodsLabel get(Long id){
		return goodsLabelRepository.getOne(id);
	}
	public List<GoodsLabel> getAll(){
		return goodsLabelRepository.findAll();
	}
	public Page<GoodsLabel> getPage(int page, int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		return goodsLabelRepository.findAll(pageable);
	}
}