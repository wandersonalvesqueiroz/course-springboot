package com.estudos.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
