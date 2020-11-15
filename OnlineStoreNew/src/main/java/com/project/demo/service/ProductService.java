package com.project.demo.service;


import com.project.demo.persitance.dto.CategoryDto;
import com.project.demo.persitance.dto.ManufacturerDto;
import com.project.demo.persitance.dto.ProductDto;
import com.project.demo.persitance.model.CategoryModel;
import com.project.demo.persitance.model.ManufacturerModel;
import com.project.demo.persitance.model.ProductModel;
import com.project.demo.persitance.model.ProductType;
import com.project.demo.repository.CategoryRepository;
import com.project.demo.repository.ManufacturerRepository;
import com.project.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    @Autowired
private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<ProductDto> getProducts(){
        List<ProductModel> productModels = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (ProductModel productModel: productModels){
            ProductDto productDto = new ProductDto();
            productDto.setId(productModel.getId());
            productDto.setPrice(productModel.getPrice());
            productDto.setName(productModel.getName());
           // productDto.setPhoto(productModel.getPhoto());
            productDto.setDescription(productModel.getDescription());
            CategoryDto categoryDto =new CategoryDto();
            categoryDto.setId(productModel.getCategory().getId());
            categoryDto.setName(productModel.getCategory().getName());
            productDto.setCategory(categoryDto);
            ManufacturerDto manufacturerDto = new ManufacturerDto();
            manufacturerDto.setId(productModel.getManufacturer().getId());
            manufacturerDto.setName(productModel.getManufacturer().getName());
            productDto.setManufacturer(manufacturerDto);
            productDto.setProductType(productModel.getProductType().name());
            productDtoList.add(productDto);
        }
        return productDtoList;
    }
 public List<ProductDto> getProductsByCategory(long id){
     List<ProductModel> productModels = productRepository.findByCategory_Id(id);
     List<ProductDto> productDtoList = new ArrayList<>();
     for (ProductModel productModel: productModels){
         ProductDto productDto = new ProductDto();
         productDto.setId(productModel.getId());
         productDto.setPrice(productModel.getPrice());
         productDto.setName(productModel.getName());
         productDto.setDescription(productModel.getDescription());
         CategoryDto categoryDto =new CategoryDto();
         categoryDto.setId(productModel.getCategory().getId());
         categoryDto.setName(productModel.getCategory().getName());
         productDto.setCategory(categoryDto);
         ManufacturerDto manufacturerDto = new ManufacturerDto();
         manufacturerDto.setId(productModel.getManufacturer().getId());
         manufacturerDto.setName(productModel.getManufacturer().getName());
         productDto.setManufacturer(manufacturerDto);
         productDto.setProductType(productModel.getProductType().name());
         productDtoList.add(productDto);
     }
     return productDtoList;
 }

    public void addProduct(ProductDto productDto){
        ProductModel productModel = new ProductModel();
        productModel.setName(productDto.getName());
        productModel.setPrice(productDto.getPrice());
        CategoryModel categoryModel = categoryRepository.findById(productDto.getCategory().getId()).orElse(null);
        productModel.setCategory(categoryModel);
        productModel.setDescription(productDto.getDescription());
        ManufacturerModel manufacturerModel = manufacturerRepository.findById(productDto.getManufacturer().getId()).orElse(null);
        productModel.setManufacturer(manufacturerModel);
        productModel.setProductType(ProductType.valueOf(productDto.getProductType()));
        productRepository.save(productModel);

    }

    public ProductDto getProduct (long id){
        ProductModel productModel = productRepository.findById(id).orElse(null);
        ProductDto productDto = new ProductDto();
        productDto.setId(productModel.getId());
        productDto.setPrice(productModel.getPrice());
        productDto.setName(productModel.getName());
       // productDto.setPhoto(productModel.getPhoto());
        productDto.setDescription(productModel.getDescription());
        CategoryDto categoryDto =new CategoryDto();
        categoryDto.setId(productModel.getCategory().getId());
        categoryDto.setName(productModel.getCategory().getName());
        productDto.setCategory(categoryDto);
        ManufacturerDto manufacturerDto = new ManufacturerDto();
        manufacturerDto.setId(productModel.getManufacturer().getId());
        manufacturerDto.setName(productModel.getManufacturer().getName());
        productDto.setManufacturer(manufacturerDto);
        return productDto;
    }
public void update (ProductDto productDto){
        ProductModel productModel = productRepository.findById(productDto.getId()).orElse(null);
    productModel.setName(productDto.getName());
    productModel.setPrice(productDto.getPrice());
    CategoryModel categoryModel = categoryRepository.findById(productDto.getCategory().getId()).orElse(null);
    productModel.setCategory(categoryModel);
    productModel.setDescription(productDto.getDescription());
    ManufacturerModel manufacturerModel = manufacturerRepository.findById(productDto.getManufacturer().getId()).orElse(null);
    productModel.setManufacturer(manufacturerModel);
    productModel.setProductType(ProductType.valueOf(productDto.getProductType()));
    productRepository.save(productModel);

}

public void delete(long id){
    ProductModel productModel = productRepository.findById(id).orElse(null);
        productRepository.delete(productModel);
}

}
