package com.project.demo.repository;


import com.project.demo.persitance.model.AdressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<AdressModel,Long> {
}
