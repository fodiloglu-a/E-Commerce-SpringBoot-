package com.commerce.commerce.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Category_Id")
    private int id;
    @Column(name = "Category_Name")

    private String categoryName;



    @OneToMany(mappedBy = "category" )
    public List<Product> productList=new ArrayList<>();

    public Category (String categoryName){
        this.categoryName=categoryName;
    }

}
