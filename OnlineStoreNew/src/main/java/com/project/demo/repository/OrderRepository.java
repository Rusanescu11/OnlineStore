package com.project.demo.repository;

import com.project.demo.persitance.model.OrderModel;
import com.project.demo.persitance.model.StatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {
   List<OrderModel> findAllByUsername(String username);

   Optional<OrderModel> findAllByUsernameAndStatus(String username, StatusModel statusModel);


}
