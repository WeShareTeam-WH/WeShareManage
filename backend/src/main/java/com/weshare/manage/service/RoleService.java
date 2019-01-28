package com.weshare.manage.service;
import java.util.List;

import com.weshare.manage.entity.Role;
import org.springframework.data.domain.Page;
public interface RoleService {
	public Role add(Role role);
	public void delete(Long id);
	public Role update(Role role);
	public Role get(Long id);
	public List<Role> getAll();
	public Page<Role> getPage(int page, int rows);
}