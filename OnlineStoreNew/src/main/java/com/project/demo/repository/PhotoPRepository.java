package com.project.demo.repository;

import com.project.demo.persitance.model.PhotoP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoPRepository extends JpaRepository<PhotoP,String> {
}
