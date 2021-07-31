package com.estudos.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
