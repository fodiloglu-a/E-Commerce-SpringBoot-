package com.commerce.commerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Product")
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor

@NoArgsConstructor
public class Product {
    @Id
    @SequenceGenerator(name = "product_Id",
                        sequenceName = "product_Id",
    allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_Id")
    private Long id;

    @Column(name = "Product_name",length = 50)
    private String productName;

    @Column(name = "Properties",length = 300)
    private String prop;
    @Column(name = "Stock")

    private int stock;

    @Column(name = "Price_tl")
    private double price;

    @ManyToOne
    @JoinColumn(name = "Category_Id")

    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Cart> cart;





 




}
