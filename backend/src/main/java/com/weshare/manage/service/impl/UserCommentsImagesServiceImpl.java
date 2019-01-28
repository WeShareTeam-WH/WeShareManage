package com.weshare.manage.service.impl;
import com.weshare.manage.entity.UserCommentsImages;
import com.weshare.manage.service.UserCommentsImagesService;
import com.weshare.manage.repository.UserCommentsImagesRepository;
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
public class UserCommentsImagesServiceImpl implements UserCommentsImagesService {
	@Autowired
	private UserCommentsImagesRepository userCommentsImagesRepository;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public UserCommentsImages add(UserCommentsImages userCommentsImages){
		return userCommentsImagesRepository.save(userCommentsImages);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void delete(Long id){
		userCommentsImagesRepository.deleteById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public UserCommentsImages update(UserCommentsImages userCommentsImages){
		return userCommentsImagesRepository.saveAndFlush(userCommentsImages);
	}
	public UserCommentsImages get(Long id){
		return userCommentsImagesRepository.getOne(id);
	}
	public List<UserCommentsImages> getAll(){
		return userCommentsImagesRepository.findAll();
	}
	public Page<UserCommentsImages> getPage(int page, int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		return userCommentsImagesRepository.findAll(pageable);
	}
}