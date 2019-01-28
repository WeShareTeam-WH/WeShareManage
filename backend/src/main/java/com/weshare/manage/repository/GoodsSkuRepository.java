package com.weshare.manage.repository;

import com.weshare.manage.entity.Goods;
import com.weshare.manage.entity.GoodsSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GoodsSkuRepository extends JpaRepository<GoodsSku, Long>, JpaSpecificationExecutor<GoodsSku> {
    List<GoodsSku> findByGoodsByGoodsId(Goods goods);
}