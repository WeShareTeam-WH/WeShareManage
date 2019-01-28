package com.weshare.manage.service.impl;
import com.weshare.manage.entity.UserAddress;
import com.weshare.manage.service.UserAddressService;
import com.weshare.manage.repository.UserAddressRepository;
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
public class UserAddressServiceImpl implements UserAddressService {
	@Autowired
	private UserAddressRepository userAddressRepository;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public UserAddress add(UserAddress userAddress){
		return userAddressRepository.save(userAddress);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void delete(Long id){
		userAddressRepository.deleteById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public UserAddress update(UserAddress userAddress){
		return userAddressRepository.saveAndFlush(userAddress);
	}
	public UserAddress get(Long id){
		return userAddressRepository.getOne(id);
	}
	public List<UserAddress> getAll(){
		return userAddressRepository.findAll();
	}
	public Page<UserAddress> getPage(int page, int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		return userAddressRepository.findAll(pageable);
	}
}