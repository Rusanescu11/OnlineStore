package com.project.demo.controller;


import com.project.demo.persitance.dto.ProductDto;
import com.project.demo.persitance.dto.files.ResponseFile;
import com.project.demo.persitance.dto.files.ResponseMessage;
import com.project.demo.persitance.model.PhotoP;
import com.project.demo.persitance.model.ProductModel;
import com.project.demo.repository.PhotoPRepository;
import com.project.demo.repository.ProductRepository;
import com.project.demo.service.PhotoPService;
import com.project.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private PhotoPService photoPService;

    @Autowired
    private PhotoPRepository photoPRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/product")
    public void addProduct(@RequestBody ProductModel productModel) {
        productRepository.save(productModel);
    }
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id) {
        productService.delete(id);
    }

    @GetMapping("/product")
    public List<ProductDto> getProduct() {
        return productService.getProducts();
    }
    @GetMapping("/product/{id}")
    public ProductDto getProduct(@PathVariable(name = "id") Long id) {
        return productService.getProduct(id);
    }
    @PutMapping("/product")
    public void update(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
    }
    @PostMapping("/photop")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("photo") MultipartFile photop) {
        String message;
        try {
            photoPService.store(photop);
            message = "Uploaded the file successfully: " + photop.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + photop.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/photoP/{id}")
    public ResponseEntity<List<ResponseFile>> getProductPhoto(@PathVariable(name = "id") Long id){
        List<ResponseFile> files = photoPService.getProductPhoto(id).map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/photop/")
                    .path(dbFile.getId())
                    .toUriString();
            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/photop/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        PhotoP photoP = photoPService.getPhoto(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photoP.getName() + "\"")
                .body(photoP.getData());
    }
    @GetMapping("/product/category/{id}")
    public List<ProductDto> getProductsByCategory(@PathVariable(name = "id") Long id) {
        return productService.getProductsByCategory(id);
    }
}
