package com.weshare.manage.service;
import java.util.List;

import com.weshare.manage.entity.ShoppingCart;
import org.springframework.data.domain.Page;
public interface ShoppingCartService {
	public ShoppingCart add(ShoppingCart shoppingCart);
	public void delete(Long id);
	public ShoppingCart update(ShoppingCart shoppingCart);
	public ShoppingCart get(Long id);
	public List<ShoppingCart> getAll();
	public Page<ShoppingCart> getPage(int page, int rows);
}