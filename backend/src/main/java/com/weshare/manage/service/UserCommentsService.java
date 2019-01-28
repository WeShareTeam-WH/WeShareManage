package com.weshare.manage.service;
import java.util.List;

import com.weshare.manage.entity.UserComments;
import org.springframework.data.domain.Page;
public interface UserCommentsService {
	public UserComments add(UserComments userComments);
	public void delete(Long id);
	public UserComments update(UserComments userComments);
	public UserComments get(Long id);
	public List<UserComments> getAll();
	public Page<UserComments> getPage(int page, int rows);
}