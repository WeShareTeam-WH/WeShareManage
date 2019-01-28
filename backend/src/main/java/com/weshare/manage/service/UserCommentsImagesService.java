package com.weshare.manage.service;
import java.util.List;

import com.weshare.manage.entity.UserCommentsImages;
import org.springframework.data.domain.Page;
public interface UserCommentsImagesService {
	public UserCommentsImages add(UserCommentsImages userCommentsImages);
	public void delete(Long id);
	public UserCommentsImages update(UserCommentsImages userCommentsImages);
	public UserCommentsImages get(Long id);
	public List<UserCommentsImages> getAll();
	public Page<UserCommentsImages> getPage(int page, int rows);
}