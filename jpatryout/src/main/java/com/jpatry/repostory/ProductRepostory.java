package com.jpatry.repostory;

import com.jpatry.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepostory extends JpaRepository<Product,Integer> {
}
