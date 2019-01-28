package com.weshare.manage.service;
import java.util.List;

import com.weshare.manage.entity.GoodsLabel;
import org.springframework.data.domain.Page;
public interface GoodsLabelService {
	public GoodsLabel add(GoodsLabel goodsLabel);
	public void delete(Long id);
	public GoodsLabel update(GoodsLabel goodsLabel);
	public GoodsLabel get(Long id);
	public List<GoodsLabel> getAll();
	public Page<GoodsLabel> getPage(int page, int rows);
}