package com.weshare.manage.repository;
import com.weshare.manage.entity.ImageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImageTypeRespository extends JpaRepository<ImageType, Integer>, JpaSpecificationExecutor<ImageType>{
}