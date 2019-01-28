package com.weshare.manage.repository;

import com.weshare.manage.entity.GoodsCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GoodsCollectionRepository extends JpaRepository<GoodsCollection, Long>, JpaSpecificationExecutor<GoodsCollection> {
}