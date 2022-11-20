package com.commerce.commerce.Repository.Product;

import com.commerce.commerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductDao extends JpaRepository<Product,Long> {




    Product findByProductName(String productName);

    List<Product> findAllByCategory_Id(int id);
    List<Product> findALLbByCart_cartId(int id);






    @Override
    void deleteById(Long aLong);

    long removeById(int id);
}
