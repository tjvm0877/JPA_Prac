package com.hyun.jpa_prac.repository;

import com.hyun.jpa_prac.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
