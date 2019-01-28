package com.weshare.manage.repository;

import com.weshare.manage.entity.GoodsAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GoodsAttributesRepository extends JpaRepository<GoodsAttributes, Long>, JpaSpecificationExecutor<GoodsAttributes> {
}