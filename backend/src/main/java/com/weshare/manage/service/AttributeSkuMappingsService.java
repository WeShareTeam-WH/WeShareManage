package com.weshare.manage.service;

import com.weshare.manage.entity.AttributesSkuMapping;

import java.util.List;

public interface AttributeSkuMappingsService {
    public void save(List<AttributesSkuMapping> attributesSkuMappings);
    public void delete(List<AttributesSkuMapping> attributesSkuMappings);
    public AttributesSkuMapping get(Long id);
}
