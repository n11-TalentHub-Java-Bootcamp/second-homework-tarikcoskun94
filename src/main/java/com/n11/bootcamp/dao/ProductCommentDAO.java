package com.n11.bootcamp.dao;

import com.n11.bootcamp.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductCommentDAO extends JpaRepository<ProductComment, Long> {

    List<ProductComment> findByUserUsername(String username);

    List<ProductComment> findByProductId(Long productId);

    //void deleteBy(Long id);
}
