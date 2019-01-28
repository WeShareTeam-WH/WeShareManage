package com.weshare.manage.service;
import java.util.List;

import com.weshare.manage.entity.Orders;
import org.springframework.data.domain.Page;
public interface OrdersService {
	public Orders add(Orders orders);
	public void delete(Long id);
	public Orders update(Orders orders);
	public Orders get(Long id);
	public List<Orders> getAll();
	public Page<Orders> getPage(int page, int rows);
}