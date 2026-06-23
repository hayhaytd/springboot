package com.fpoly.springboot.service;

import com.fpoly.springboot.model.ProductDb;
import com.fpoly.springboot.repository.ProductDbRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductDbService {

    private final ProductDbRepository productDbRepository;

    public ProductDbService(
            ProductDbRepository productDbRepository) {

        this.productDbRepository = productDbRepository;
    }

    public List<ProductDb> getAllProducts() {
        log.info("Lấy danh sách sản phẩm");
        return productDbRepository.findAll();
    }

    public Optional<ProductDb> getProductById(Long id) {
        log.info("Tìm sản phẩm id={}", id);
        return productDbRepository.findById(id);
    }

    public ProductDb addProduct(ProductDb product) {
        log.info("Thêm sản phẩm {}", product.getName());
        return productDbRepository.save(product);
    }

    public Page getProductsWithPagination(int page, int size, String sortBy) {
    // Thiết lập PageRequest hỗ trợ chỉ số trang bắt đầu từ 0, giới hạn số lượng và sắp xếp tăng dần tự động
    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
    return productDbRepository.findAll(pageable);
    }
    
    public List<Object[]> countProductsByCategory() {
    return productDbRepository.countProductsByCategory();
    }

    

}