package com.weshare.manage.repository;

import com.weshare.manage.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
;

public interface GoodsRepository extends JpaRepository<Goods, Long> , JpaSpecificationExecutor<Goods>{

}
