package com.fpoly.springboot.model;

import com.fpoly.springboot.validation.ValidPhoneNumber;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false, length = 150)
    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Size(min = 3, max = 50, message = "Tên sản phẩm từ 3 đến 50 ký tự")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Giá không được để trống")
    @DecimalMin(value = "1000", message = "Giá phải lớn hơn hoặc bằng 1000")
    private Double price;

    @NotNull(message = "Danh mục không được để trống")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    // @NotBlank(message = "Số điện thoại không được để trống")
    // @ValidPhoneNumber
    // private String phoneNumber;

}