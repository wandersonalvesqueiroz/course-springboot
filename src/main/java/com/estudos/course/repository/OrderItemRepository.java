package com.estudos.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
