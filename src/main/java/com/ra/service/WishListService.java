package com.ra.service;

import com.ra.model.entity.WishList;

import java.util.List;

public interface WishListService {
    WishList add(Long userId, Long productId);
    List<WishList> getAll(Long userId);
    void delete(Long wishListId, Long userId);
}
