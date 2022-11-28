package com.hyun.jpa_prac.repository;

import com.hyun.jpa_prac.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
