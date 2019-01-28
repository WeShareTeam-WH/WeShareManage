package com.weshare.manage.repository;

import com.weshare.manage.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long>, JpaSpecificationExecutor<ShoppingCart> {
}