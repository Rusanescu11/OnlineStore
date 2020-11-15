package com.project.demo.repository;


import com.project.demo.persitance.model.CategoryModel;
import com.project.demo.persitance.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

    List<CategoryModel> findByParent_Id(long id);

}
