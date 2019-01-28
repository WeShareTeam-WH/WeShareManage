package com.weshare.manage.repository;

import com.weshare.manage.entity.GoodsLabelMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GoodsLabelMappingRespository extends JpaRepository<GoodsLabelMapping, Long>, JpaSpecificationExecutor<GoodsLabelMapping> {
    public List<GoodsLabelMapping> queryAllByGoodsId(Long id);
}
