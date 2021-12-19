package com.n11.bootcamp.controller;

import com.n11.bootcamp.dto.CommentWithUserAndProductDTO;
import com.n11.bootcamp.service.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "product-comments")
public class ProductCommentController {

    private final ProductCommentService productCommentService;

    @GetMapping(value = "/with-username/{username}")
    public ResponseEntity<List<CommentWithUserAndProductDTO>> findByUserUsername(@PathVariable String username) {

        return ResponseEntity.ok(productCommentService.findByUserUsername(username));
    }

    @GetMapping(value = "/with-product-id/{id}")
    public ResponseEntity<List<CommentWithUserAndProductDTO>> findByProductId(@PathVariable Long id) {

        return ResponseEntity.ok(productCommentService.findByProductId(id));
    }
}
