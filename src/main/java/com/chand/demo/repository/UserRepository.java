package com.chand.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chand.demo.data.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
