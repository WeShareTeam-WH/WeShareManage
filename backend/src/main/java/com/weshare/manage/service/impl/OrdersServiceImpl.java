package com.weshare.manage.service.impl;
import com.weshare.manage.entity.Orders;
import com.weshare.manage.service.OrdersService;
import com.weshare.manage.repository.OrdersRepository;
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
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersRepository ordersRepository;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public Orders add(Orders orders){
		return ordersRepository.save(orders);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void delete(Long id){
		ordersRepository.deleteById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public Orders update(Orders orders){
		return ordersRepository.saveAndFlush(orders);
	}
	public Orders get(Long id){
		return ordersRepository.getOne(id);
	}
	public List<Orders> getAll(){
		return ordersRepository.findAll();
	}
	public Page<Orders> getPage(int page, int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		return ordersRepository.findAll(pageable);
	}
}