package com.fpoly.springboot.service;

import com.fpoly.springboot.dto.ProductDTO;
import com.fpoly.springboot.model.ProductDb;
import com.fpoly.springboot.repository.ProductDbRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class ProductBackupService {

    private final ProductDbRepository repository;

    public ProductBackupService(
            ProductDbRepository repository) {

        this.repository = repository;
    }

    public ProductDTO getProductDtoInfo(Long id){

        log.info("Tìm sản phẩm id={}",id);

        ProductDb product =
                repository.findById(id)
                        .orElseThrow(() -> {

                            log.error(
                                    "Không tìm thấy id={}",
                                    id);

                            return new RuntimeException(
                                    "Không tìm thấy sản phẩm");
                        });

        ProductDTO dto =
                new ProductDTO();

        dto.setName(product.getName());
        dto.setPrice(product.getPrice());

        log.info(
                "Convert DTO thành công");

        return dto;
    }
}
