package com.weshare.manage.repository;

import com.weshare.manage.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long>, JpaSpecificationExecutor<UserAddress> {
}