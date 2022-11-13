package com.commerce.commerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

import java.sql.SQLTransactionRollbackException;
import java.util.List;
@Entity
@Data
@Table(name = "Cart")
@NoArgsConstructor
@AllArgsConstructor

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartId")
    private int cartId;

    @Column(name = "cartNo")
    private int cartNo;

    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Product product;

















}
