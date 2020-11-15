package com.project.demo.repository;


import com.project.demo.persitance.model.OrderLineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLineModel,Long> {

}
