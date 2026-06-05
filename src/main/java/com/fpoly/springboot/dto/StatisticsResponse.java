package com.fpoly.springboot.dto;

public class StatisticsResponse {

    private int totalProducts;
    private double averagePrice;
    private double maxPrice;
    private double minPrice;

    public StatisticsResponse() {
    }

    public StatisticsResponse(
            int totalProducts,
            double averagePrice,
            double maxPrice,
            double minPrice) {

        this.totalProducts = totalProducts;
        this.averagePrice = averagePrice;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
    }

    public int getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }
}
