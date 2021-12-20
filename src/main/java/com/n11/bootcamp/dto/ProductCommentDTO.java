package com.n11.bootcamp.dto;

import com.n11.bootcamp.entity.Product;
import com.n11.bootcamp.entity.ProductComment;
import com.n11.bootcamp.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Data
@Builder
public class ProductCommentDTO {

    private Long commentId;
    private String commentText;
    private Date commentCreationDate;
    private Long productId;
    private Long userId;

    public static ProductCommentDTO convertProductCommentToProductCommentDTO (ProductComment productComment){

        return ProductCommentDTO.builder()
                .commentId(productComment.getId())
                .commentText(productComment.getText())
                .commentCreationDate(productComment.getCreationDate())
                .productId(productComment.getProduct().getId())
                .userId(productComment.getUser().getId())
                .build();
    }

    public static ProductComment convertProductCommentDTOToProductComment (ProductCommentDTO productCommentDTO){

        Product productTemp = new Product();
        User userTemp = new User();

        productTemp.setId(productCommentDTO.getProductId());
        userTemp.setId(productCommentDTO.getUserId());

        return ProductComment.builder()
                .id(productCommentDTO.getCommentId())
                .text(productCommentDTO.getCommentText())
                .creationDate(productCommentDTO.getCommentCreationDate())
                .product(productTemp)
                .user(userTemp)
                .build();
    }
}