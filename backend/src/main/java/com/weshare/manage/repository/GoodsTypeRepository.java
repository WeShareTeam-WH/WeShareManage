package com.weshare.manage.repository;

import com.weshare.manage.entity.GoodsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GoodsTypeRepository extends JpaRepository<GoodsType, Long>, JpaSpecificationExecutor<GoodsType> {
}