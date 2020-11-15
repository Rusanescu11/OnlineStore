package com.project.demo.persitance.dto;

import com.project.demo.persitance.model.PromoCode;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private long id;
    private String username;
    private double totalCost;
    private String deliveryAddress;
    private String userAddress;
    private Date orderDate;
    private String status;
    private List<OrderLineDto> orderLines = new ArrayList<>();
    private PromoCodeDto promoCodeDto;
    private String additionalComment;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public String getUserAddress() {
        return userAddress;
    }
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderLineDto> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLineDto> orderLines) {
        this.orderLines = orderLines;
    }

    public String getAdditionalComment() {
        return additionalComment;
    }

    public void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }

    public PromoCodeDto getPromoCodeDto() {
        return promoCodeDto;
    }

    public void setPromoCodeDto(PromoCodeDto promoCodeDto) {
        this.promoCodeDto = promoCodeDto;
    }
}
