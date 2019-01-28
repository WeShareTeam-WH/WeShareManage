package com.weshare.manage.service.impl;
import com.weshare.manage.entity.OrderDetail;
import com.weshare.manage.service.OrderDetailService;
import com.weshare.manage.repository.OrderDetailRepository;
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
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public OrderDetail add(OrderDetail orderDetail){
		return orderDetailRepository.save(orderDetail);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void delete(Long id){
		orderDetailRepository.deleteById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public OrderDetail update(OrderDetail orderDetail){
		return orderDetailRepository.saveAndFlush(orderDetail);
	}
	public OrderDetail get(Long id){
		return orderDetailRepository.getOne(id);
	}
	public List<OrderDetail> getAll(){
		return orderDetailRepository.findAll();
	}
	public Page<OrderDetail> getPage(int page, int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		return orderDetailRepository.findAll(pageable);
	}
}