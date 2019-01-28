package com.weshare.manage.service;
import java.util.List;

import com.weshare.manage.entity.GoodsType;
import org.springframework.data.domain.Page;
public interface GoodsTypeService {
	public GoodsType add(GoodsType goodsType);
	public void delete(Long id);
	public GoodsType update(GoodsType goodsType);
	public GoodsType get(Long id);
	public List<GoodsType> getAll();
	public Page<GoodsType> getPage(int page, int rows);
}