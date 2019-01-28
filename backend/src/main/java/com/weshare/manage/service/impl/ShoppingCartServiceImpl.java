package com.weshare.manage.service.impl;
import com.weshare.manage.entity.ShoppingCart;
import com.weshare.manage.service.ShoppingCartService;
import com.weshare.manage.repository.ShoppingCartRepository;
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
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public ShoppingCart add(ShoppingCart shoppingCart){
		return shoppingCartRepository.save(shoppingCart);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void delete(Long id){
		shoppingCartRepository.deleteById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public ShoppingCart update(ShoppingCart shoppingCart){
		return shoppingCartRepository.saveAndFlush(shoppingCart);
	}
	public ShoppingCart get(Long id){
		return shoppingCartRepository.getOne(id);
	}
	public List<ShoppingCart> getAll(){
		return shoppingCartRepository.findAll();
	}
	public Page<ShoppingCart> getPage(int page, int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		return shoppingCartRepository.findAll(pageable);
	}
}