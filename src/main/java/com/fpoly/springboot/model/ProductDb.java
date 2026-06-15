package com.fpoly.springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fpoly.springboot.model.Category;

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
    @Min(value = 1000,message = "Giá phải lớn hơn hoặc bằng 1000")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}