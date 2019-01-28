package com.weshare.manage.service;
import java.util.List;

import com.weshare.manage.entity.UserAddress;
import org.springframework.data.domain.Page;
public interface UserAddressService {
	public UserAddress add(UserAddress userAddress);
	public void delete(Long id);
	public UserAddress update(UserAddress userAddress);
	public UserAddress get(Long id);
	public List<UserAddress> getAll();
	public Page<UserAddress> getPage(int page, int rows);
}