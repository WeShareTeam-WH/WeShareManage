package com.weshare.manage.service;
import java.util.List;

import com.weshare.manage.entity.GoodsDescription;
import org.springframework.data.domain.Page;
public interface GoodsDescriptionService {
	public GoodsDescription add(GoodsDescription goodsDescription);
	public void delete(Long id);
	public GoodsDescription update(GoodsDescription goodsDescription);
	public GoodsDescription get(Long id);
	public List<GoodsDescription> getAll();
	public Page<GoodsDescription> getPage(int page, int rows);
}