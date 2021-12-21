package com.n11.bootcamp.service.impl;

import com.n11.bootcamp.dao.ProductCommentDAO;
import com.n11.bootcamp.dto.CommentWithUserAndProductDTO;
import com.n11.bootcamp.dto.ProductCommentDTO;
import com.n11.bootcamp.entity.ProductComment;
import com.n11.bootcamp.exception.ApiRequestException;
import com.n11.bootcamp.service.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductCommentServiceImpl implements ProductCommentService {

    private final ProductCommentDAO productCommentDAO;

    @Override
    public List<CommentWithUserAndProductDTO> findByUserUsername(String username) {

        List<CommentWithUserAndProductDTO> commentWithUserAndProductDTOList = new ArrayList<>();
        List<ProductComment> productCommentList = productCommentDAO.findByUserUsername(username);

        for (ProductComment productComment : productCommentList) {
            commentWithUserAndProductDTOList.add(CommentWithUserAndProductDTO.convertProductCommentToCommentWithUserAndProductDTO(productComment));
        }

        return commentWithUserAndProductDTOList;
    }

    @Override
    public List<CommentWithUserAndProductDTO> findByProductId(Long id) {

        List<CommentWithUserAndProductDTO> commentWithUserAndProductDTOList = new ArrayList<>();
        List<ProductComment> productCommentList = productCommentDAO.findByProductId(id);

        for (ProductComment productComment : productCommentList) {
            commentWithUserAndProductDTOList.add(CommentWithUserAndProductDTO.convertProductCommentToCommentWithUserAndProductDTO(productComment));
        }

        return commentWithUserAndProductDTOList;
    }

    @Override
    public ProductCommentDTO saveProductComment(ProductCommentDTO productCommentDTO) {

        ProductComment requestProductComment = ProductCommentDTO.convertProductCommentDTOToProductComment(productCommentDTO);
        ProductComment responseProductComment = productCommentDAO.save(requestProductComment);

        return ProductCommentDTO.convertProductCommentToProductCommentDTO(responseProductComment);
    }

    @Override
    @Transactional
    public void deleteProductCommentById(Long id) {

        productCommentDAO.findById(id).orElseThrow(() -> new ApiRequestException("Product comment is not found by id."));
        productCommentDAO.deleteProductCommentById(id);
    }
}
