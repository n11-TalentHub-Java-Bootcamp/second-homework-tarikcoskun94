package com.n11.bootcamp.service;

import com.n11.bootcamp.dto.CommentWithUserAndProductDTO;
import com.n11.bootcamp.dto.ProductCommentDTO;
import com.n11.bootcamp.entity.ProductComment;

import java.util.List;

public interface ProductCommentService {
    List<CommentWithUserAndProductDTO> findByUserUsername(String username);

    List<CommentWithUserAndProductDTO> findByProductId(Long id);

    ProductCommentDTO saveProductComment(ProductCommentDTO productCommentDTO);

    void deleteProductCommentById(Long id);
}
