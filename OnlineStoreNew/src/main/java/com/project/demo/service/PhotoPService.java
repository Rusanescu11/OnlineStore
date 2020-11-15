package com.project.demo.service;

import com.project.demo.persitance.model.PhotoP;
import com.project.demo.persitance.model.PhotoU;
import com.project.demo.persitance.model.ProductModel;
import com.project.demo.persitance.model.UserModel;
import com.project.demo.repository.PhotoPRepository;
import com.project.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Service
public class PhotoPService {

    @Autowired
    private PhotoPRepository photoPRepository;

    @Autowired
    private ProductRepository productRepository;

    public PhotoP store(MultipartFile file) throws IOException, InterruptedException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        PhotoP photoP = new PhotoP(fileName, file.getContentType(), file.getBytes());
        TimeUnit.SECONDS.sleep(3);
        List<ProductModel> products = productRepository.findAll();
        ProductModel productModel = products.get(products.size()-1);
        photoP.setProduct(productModel);
        return photoPRepository.save(photoP);
    }

    public PhotoP getPhoto(String id) {
        return photoPRepository.findById(id).get();
    }


    public Stream<PhotoP> getProductPhoto(long id) {
        ProductModel productModel = productRepository.findById(id).orElse(null);
        List<PhotoP> list = new ArrayList<>();
        list.add(productModel.getPhotos());
        return list.stream();
    }

}
