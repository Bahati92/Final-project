package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.STUDENTRESULT;

@Repository
public interface StudentResultRepository extends JpaRepository <STUDENTRESULT,Integer> {

}
