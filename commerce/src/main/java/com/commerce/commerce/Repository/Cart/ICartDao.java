package com.commerce.commerce.Repository.Cart;

import com.commerce.commerce.Entity.Cart;
import com.commerce.commerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ICartDao extends JpaRepository<Cart,Integer> {
    @Transactional
    @Modifying
    @Query("delete from Cart c where c.cartNo = ?1")
    int deleteByCartNo(int cartNo);

    List<Cart> findByCartNo(int cartNo);






}
