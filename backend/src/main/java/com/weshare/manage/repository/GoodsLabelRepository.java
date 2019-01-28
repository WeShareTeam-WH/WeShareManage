package com.weshare.manage.repository;

import com.weshare.manage.entity.Goods;
import com.weshare.manage.entity.GoodsLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import java.util.List;

public interface GoodsLabelRepository extends JpaRepository<GoodsLabel, Long>, JpaSpecificationExecutor<GoodsLabel> {
    @Query(value = "select goodsLabel from GoodsLabel as goodsLabel inner join GoodsLabelMapping as mapping on goodsLabel.id = mapping.goodsLabelId where mapping.goodsId = ?1")
    public List<GoodsLabel> queryAllByGoodsId(Long goodsId);
}