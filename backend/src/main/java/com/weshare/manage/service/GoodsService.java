package com.weshare.manage.service;
import java.util.List;

import com.weshare.manage.entity.Goods;
import com.weshare.manage.entity.GoodsDetailModel;
import org.springframework.data.domain.Page;
public interface GoodsService {
	public void addGoodsBasic(GoodsDetailModel goodsDetailModel);
	public void editGoodsBasic(GoodsDetailModel goodsDetailModel);
	public void addGoodsDescription(GoodsDetailModel goodsDetailModel);
	public Goods findBasicGoodsById(Long id);
	public void delete(Long id);
	public Goods update(Goods goods);
	public GoodsDetailModel get(Long id);
	public List<Goods> getAll();
	public Page<Goods> getPage(int page, int rows);
}