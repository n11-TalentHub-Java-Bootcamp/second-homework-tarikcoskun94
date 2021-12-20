package com.n11.bootcamp.dao;

import com.n11.bootcamp.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductCommentDAO extends JpaRepository<ProductComment, Long> {

    List<ProductComment> findByUserUsername(String username);

    List<ProductComment> findByProductId(Long productId);

    Optional<ProductComment> findById(Long id);

    void deleteProductCommentById(Long id);
}
