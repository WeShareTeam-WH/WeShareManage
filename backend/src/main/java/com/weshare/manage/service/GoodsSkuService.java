package com.weshare.manage.service;
import java.util.List;

import com.weshare.manage.entity.GoodsDetailModel;
import com.weshare.manage.entity.GoodsSku;
import org.springframework.data.domain.Page;
public interface GoodsSkuService {
	public GoodsSku save(GoodsSku goodsSku);
	public void delete(Long id);
	public GoodsSku update(GoodsSku goodsSku);
	public GoodsSku get(Long id);
	public List<GoodsSku> getAll();
	public Page<GoodsSku> getPage(int page, int rows);
}