package com.project.demo.service;


import com.project.demo.persitance.dto.CategoryDto;
import com.project.demo.persitance.model.CategoryModel;
import com.project.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDto> getAllCategories(){
        List<CategoryModel> categories = categoryRepository.findAll();
         List<CategoryDto> categoriesDto = new ArrayList<>();
         for (CategoryModel categoryModel: categories){
             CategoryDto categoryDto = new CategoryDto();
             categoryDto.setId(categoryModel.getId());
             categoryDto.setName(categoryModel.getName());
             if (categoryModel.getParent()!= null){
                 CategoryModel paternM = categoryModel.getParent();
                 CategoryDto paternD = new CategoryDto();
                 paternD.setId(paternM.getId());
                 paternD.setName(paternM.getName());
                 categoryDto.setParent(paternD);
             }
             categoriesDto.add(categoryDto);
         }

         return categoriesDto;
    }

    public List<CategoryDto> findCategoriesByParent(long id){
        List<CategoryModel> categories = categoryRepository.findByParent_Id(id);
        List<CategoryDto> categoriesDto = new ArrayList<>();
        for (CategoryModel categoryModel: categories){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(categoryModel.getId());
            categoryDto.setName(categoryModel.getName());
            if (categoryModel.getParent()!= null){
                CategoryModel paternM = categoryModel.getParent();
                CategoryDto paternD = new CategoryDto();
                paternD.setId(paternM.getId());
                paternD.setName(paternM.getName());
                categoryDto.setParent(paternD);
            }
            categoriesDto.add(categoryDto);
        }

        return categoriesDto;

    }

    public List<CategoryDto> getCategories(){
        List <CategoryDto> categoriesAll = getAllCategories();
        List <CategoryDto> categories = new ArrayList<>();
        for (CategoryDto categoryDto: categoriesAll){
            if (categoryDto.getParent()==null){
                categories.add(categoryDto);
            }
        }
        List<CategoryDto> subCategories = getSubCategories();
        for (CategoryDto subCat: subCategories){
            for (CategoryDto cat: categories){
                if (subCat.getParent().getId()==cat.getId()){
                    cat.getSubcategories().add(subCat);
                }
            }
        }

        return categories;
    }


    public List<CategoryDto> getSubCategories(){
        List <CategoryDto> categoriesAll = getAllCategories();
        List <CategoryDto> subCategories = new ArrayList<>();
        for (CategoryDto categoryDto: categoriesAll){
            if (categoryDto.getParent()!=null){
                subCategories.add(categoryDto);
            }
        }
        return subCategories;
    }

    public void add(CategoryDto categoryDto){
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setName(categoryDto.getName());
        CategoryDto parentCategory= categoryDto.getParent();
        if (parentCategory != null){
            CategoryModel parentCategoryModel = categoryRepository.findById(parentCategory.getId()).orElse(null);
            categoryModel.setParent(parentCategoryModel);
        }
        categoryRepository.save(categoryModel);

    }
 public CategoryDto getCategory(long id){
CategoryModel categoryModel = categoryRepository.findById(id).orElse(null);
CategoryDto categoryDto = new CategoryDto();
categoryDto.setId(categoryModel.getId());
categoryDto.setName(categoryModel.getName());
         List<CategoryModel> subCategories = categoryModel.getSubcategories();
         List<CategoryDto> subCategoryDtos = new ArrayList<>();
         for (CategoryModel subCategory: subCategories){
             CategoryDto subCategoryDto = new CategoryDto();
             subCategoryDto.setId(subCategory.getId());
             subCategoryDto.setName(subCategory.getName());
             subCategoryDtos.add(subCategoryDto);
         }
         categoryDto.setSubcategories(subCategoryDtos);
         return categoryDto;
 }
public void delete(long id){
      categoryRepository.deleteById(id);
}

public void update(CategoryDto categoryDto){
        CategoryModel categoryModel = categoryRepository.findById(categoryDto.getId()).orElse(null);
    categoryModel.setName(categoryDto.getName());
    CategoryDto parentCategory= categoryDto.getParent();
    if (parentCategory != null){
        CategoryModel parentCategoryModel = categoryRepository.findById(parentCategory.getId()).orElse(null);
        categoryModel.setParent(parentCategoryModel);
    }
    categoryRepository.save(categoryModel);
}
}
