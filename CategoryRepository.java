package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CATEGORY;

public interface CategoryRepository extends JpaRepository <CATEGORY, Integer>{

}
