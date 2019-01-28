package com.weshare.manage.service;
import java.util.List;

import com.weshare.manage.entity.GoodsAttributes;
import org.springframework.data.domain.Page;
public interface GoodsAttributesService {
	public GoodsAttributes add(GoodsAttributes goodsAttributes);
	public void delete(Long id);
	public GoodsAttributes update(GoodsAttributes goodsAttributes);
	public GoodsAttributes get(Long id);
	public List<GoodsAttributes> getAll();
	public Page<GoodsAttributes> getPage(int page, int rows);
}