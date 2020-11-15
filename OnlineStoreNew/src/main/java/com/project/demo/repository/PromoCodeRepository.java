package com.project.demo.repository;

import com.project.demo.persitance.model.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface PromoCodeRepository  extends JpaRepository<PromoCode,Long> {
        public Optional<PromoCode> getByCode(String code);
    }

