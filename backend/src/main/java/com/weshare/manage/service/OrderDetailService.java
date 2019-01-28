package com.weshare.manage.service;
import java.util.List;

import com.weshare.manage.entity.OrderDetail;
import org.springframework.data.domain.Page;
public interface OrderDetailService {
	public OrderDetail add(OrderDetail orderDetail);
	public void delete(Long id);
	public OrderDetail update(OrderDetail orderDetail);
	public OrderDetail get(Long id);
	public List<OrderDetail> getAll();
	public Page<OrderDetail> getPage(int page, int rows);
}