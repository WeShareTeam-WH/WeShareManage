package com.weshare.manage.service;
import java.util.List;

import com.weshare.manage.entity.User;
import org.springframework.data.domain.Page;
public interface UserService {
	public User add(User user);
	public void delete(Long id);
	public User update(User user);
	public User get(Long id);
	public List<User> getAll();
	public Page<User> getPage(int page, int rows);
}