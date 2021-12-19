package com.n11.bootcamp.service;

import com.n11.bootcamp.dto.CommentWithUserAndProductDTO;

import java.util.List;

public interface ProductCommentService {
    List<CommentWithUserAndProductDTO> findByUserUsername(String username);

    List<CommentWithUserAndProductDTO> findByProductId(Long id);
}
