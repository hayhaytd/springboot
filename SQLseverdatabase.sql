CREATE DATABASE FpolySpringBoot
go
DROP TABLE products;

CREATE TABLE categories (
    id INT IDENTITY(1,1) PRIMARY KEY,
    category_name NVARCHAR(100) NOT NULL,
    description NVARCHAR(MAX),
    created_at DATETIME DEFAULT GETDATE()
);

CREATE TABLE products (
    id INT IDENTITY(1,1) PRIMARY KEY,
    product_name NVARCHAR(255) NOT NULL,
    description NVARCHAR(MAX),
    price DECIMAL(12,2) NOT NULL DEFAULT 0,
    category_id INT,
    created_at DATETIME DEFAULT GETDATE(),
    CONSTRAINT fk_products_category
        FOREIGN KEY (category_id) REFERENCES categories(id)
        ON DELETE SET NULL
);

INSERT INTO categories (category_name) VALUES
(N'Điện thoại'),
(N'Laptop'),
(N'Phụ kiện');

INSERT INTO products (product_name, price, category_id) VALUES
(N'iPhone 15 Pro Max', 34990000.0, 1),
(N'Samsung Galaxy S24 Ultra', 29990000.0, 1),
(N'Xiaomi 14 Ultra', 22500000.0, 1),
(N'MacBook Air M3', 27990000.0, 2),
(N'ASUS ROG Strix G16', 38500000.0, 2),
(N'Acer Nitro V', 19500000.0, 2),
(N'Chuột Logitech G102', 400000.0, 3),
(N'Bàn phím cơ AKKO 3098B', 1650000.0, 3),
(N'Tai nghe Sony WH-1000XM5', 6500000.0, 3),
(N'Sạc Dự Phòng Anker 20000mAh', 950000.0, 3);