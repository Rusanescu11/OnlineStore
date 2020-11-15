package com.project.demo.repository;


import com.project.demo.persitance.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {
    Optional<UserModel> getUserModelByEmail(String email);

    Optional<UserModel> findUserModelByEmail(String email);


}
