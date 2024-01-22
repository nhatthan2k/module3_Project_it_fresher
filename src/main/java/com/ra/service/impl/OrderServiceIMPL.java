package com.ra.service.impl;

import com.ra.model.entity.*;
import com.ra.repository.OrderRepository;
import com.ra.service.OrderService;
import com.ra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Orders> getAll(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override
    public Orders add(Address address, Double totalPrice) {
        Orders order = Orders.builder()
                .users(address.getUsers())
                .price(totalPrice)
                .status(EOrderStatus.WAITING)
                .receiveName(address.getReceiveName())
                .receiveAddress(address.getAddress())
                .receivePhone(address.getPhone())
                .build();
        return orderRepository.save(order);
    }

    @Override
    public Orders getbySerial(Long userId, String serial) {
        return orderRepository.findByUserIdAndSerial(userId, serial);
    }

    @Override
    public List<Orders> getByStatus(Long userId, EOrderStatus status) {
        return orderRepository.findByUserIdAndStatus(userId, status);
    }

    @Override
    public Orders save(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public Orders getByIdAndStatus(Long userId, Long orderId, EOrderStatus status) {
        return orderRepository.findByIdAndStatus(userId, orderId, status);
    }
}
