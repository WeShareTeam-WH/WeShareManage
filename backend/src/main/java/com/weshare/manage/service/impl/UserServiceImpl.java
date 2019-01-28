package com.weshare.manage.service.impl;
import com.weshare.manage.entity.User;
import com.weshare.manage.service.UserService;
import com.weshare.manage.repository.UserRepository;
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
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public User add(User user){
		return userRepository.save(user);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void delete(Long id){
		userRepository.deleteById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public User update(User user){
		return userRepository.saveAndFlush(user);
	}
	public User get(Long id){
		return userRepository.getOne(id);
	}
	public List<User> getAll(){
		return userRepository.findAll();
	}
	public Page<User> getPage(int page, int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		return userRepository.findAll(pageable);
	}
}