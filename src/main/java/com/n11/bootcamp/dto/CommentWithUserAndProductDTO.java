package com.n11.bootcamp.dto;

import com.n11.bootcamp.entity.ProductComment;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
@Builder
public class CommentWithUserAndProductDTO {

    private Long commentId;
    private String commentText;
    private Date commentCreationDate;

    private String userUsername;
    private String userFirstName;
    private String userSurname;
    private String userEmail;
    private String userPhoneNumber;

    private String productName;
    private BigDecimal productPrice;
    private Date productCreationDate;

    private String categoryName;
    private Long categoryBreakdown;
    private String superCategoryName;

    public static CommentWithUserAndProductDTO convertProductCommentToCommentWithUserAndProductDTO(ProductComment productComment) {

        return CommentWithUserAndProductDTO.builder()
                .commentId(productComment.getId())
                .commentText(productComment.getText())
                .commentCreationDate(productComment.getCreationDate())

                .userUsername(productComment.getUser().getUsername())
                .userFirstName(productComment.getUser().getName())
                .userSurname(productComment.getUser().getSurname())
                .userEmail(productComment.getUser().getEmail())
                .userPhoneNumber(productComment.getUser().getPhoneNumber())

                .productName(productComment.getProduct().getName())
                .productPrice(productComment.getProduct().getPrice())
                .productCreationDate(productComment.getCreationDate())

                .categoryName(productComment.getProduct().getCategory().getName())
                .categoryBreakdown(productComment.getProduct().getCategory().getBreakdown())
                .superCategoryName(productComment.getProduct().getCategory().getSuperCategory().getName())

                .build();
    }
}
