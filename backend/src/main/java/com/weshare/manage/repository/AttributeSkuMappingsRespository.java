package com.weshare.manage.repository;

import com.weshare.manage.entity.AttributesSkuMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AttributeSkuMappingsRespository extends JpaRepository<AttributesSkuMapping, Long>, JpaSpecificationExecutor<AttributesSkuMapping> {
}
