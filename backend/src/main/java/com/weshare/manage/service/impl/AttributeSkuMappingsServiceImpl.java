package com.weshare.manage.service.impl;

import com.weshare.manage.entity.AttributesSkuMapping;
import com.weshare.manage.repository.AttributeSkuMappingsRespository;
import com.weshare.manage.service.AttributeSkuMappingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AttributeSkuMappingsServiceImpl implements AttributeSkuMappingsService {

    @Autowired
    private AttributeSkuMappingsRespository attributeSkuMappingsRespository;

    @Override
    @Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void save(List<AttributesSkuMapping> attributesSkuMappings) {
        for (AttributesSkuMapping attributesSkuMapping : attributesSkuMappings)
        {
            attributeSkuMappingsRespository.save(attributesSkuMapping);
        }
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void delete(List<AttributesSkuMapping> attributesSkuMappings){
        for (AttributesSkuMapping attributesSkuMapping : attributesSkuMappings)
        {
            attributeSkuMappingsRespository.deleteById(attributesSkuMapping.getId());
        }
    }

    @Override
    public AttributesSkuMapping get(Long id) {
        return attributeSkuMappingsRespository.findById(id).get();
    }

}
