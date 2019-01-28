package com.weshare.manage.service;
import java.util.List;

import com.weshare.manage.entity.GoodsCollection;
import org.springframework.data.domain.Page;
public interface GoodsCollectionService {
	public GoodsCollection add(GoodsCollection goodsCollection);
	public void delete(Long id);
	public GoodsCollection update(GoodsCollection goodsCollection);
	public GoodsCollection get(Long id);
	public List<GoodsCollection> getAll();
	public Page<GoodsCollection> getPage(int page, int rows);
}