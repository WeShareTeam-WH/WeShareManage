package com.weshare.manage.service.impl;
import com.weshare.manage.entity.UserComments;
import com.weshare.manage.service.UserCommentsService;
import com.weshare.manage.repository.UserCommentsRepository;
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
public class UserCommentsServiceImpl implements UserCommentsService {
	@Autowired
	private UserCommentsRepository userCommentsRepository;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public UserComments add(UserComments userComments){
		return userCommentsRepository.save(userComments);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void delete(Long id){
		userCommentsRepository.deleteById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public UserComments update(UserComments userComments){
		return userCommentsRepository.saveAndFlush(userComments);
	}
	public UserComments get(Long id){
		return userCommentsRepository.getOne(id);
	}
	public List<UserComments> getAll(){
		return userCommentsRepository.findAll();
	}
	public Page<UserComments> getPage(int page, int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		return userCommentsRepository.findAll(pageable);
	}
}