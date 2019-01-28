package com.weshare.manage.repository;

import com.weshare.manage.entity.Goods;
import com.weshare.manage.entity.GoodsDescription;
import com.weshare.manage.entity.ImageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GoodsDescriptionRepository extends JpaRepository<GoodsDescription, Long>, JpaSpecificationExecutor<GoodsDescription> {
    List<GoodsDescription> findByGoodsByGoodsId(Goods goods);

    GoodsDescription findByGoodsByGoodsIdAndImageTypeByImageTypeId(Goods goods, ImageType imageType);
}