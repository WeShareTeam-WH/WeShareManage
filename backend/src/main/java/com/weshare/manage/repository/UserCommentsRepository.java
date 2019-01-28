package com.weshare.manage.repository;
import com.weshare.manage.entity.UserComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface UserCommentsRepository extends JpaRepository<UserComments,Long>,JpaSpecificationExecutor<UserComments> {
}