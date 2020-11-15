package com.project.demo.persitance.dto;

public class PromoCodeDto {
    private long id;
    private String code;
    private double promoNumber;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public double getPromoNumber() {
        return promoNumber;
    }
    public void setPromoNumber(double promoNumber) {
        this.promoNumber = promoNumber;
    }
}

