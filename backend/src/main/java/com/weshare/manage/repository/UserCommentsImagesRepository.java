package com.weshare.manage.repository;
import com.weshare.manage.entity.UserCommentsImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface UserCommentsImagesRepository extends JpaRepository<UserCommentsImages,Long>,JpaSpecificationExecutor<UserCommentsImages> {
}