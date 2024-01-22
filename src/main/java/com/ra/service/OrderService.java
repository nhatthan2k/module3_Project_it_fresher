package com.ra.service;

import com.ra.model.entity.Address;
import com.ra.model.entity.EOrderStatus;
import com.ra.model.entity.Orders;
import com.ra.model.entity.ShopingCart;

import java.util.List;

public interface OrderService {
    List<Orders> getAll(Long userId);
    Orders add(Address address, Double totalPrice);
    Orders getbySerial(Long userId, String serial);
    List<Orders> getByStatus(Long userId, EOrderStatus status);
    Orders save(Orders orders);
    Orders getByIdAndStatus(Long userId, Long orderId, EOrderStatus status);
}
