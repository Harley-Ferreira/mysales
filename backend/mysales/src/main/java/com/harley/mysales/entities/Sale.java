package com.harley.mysales.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_sales")
public class Sale {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "seller_name")
    private String sellerName;

    @Column(name = "visits")
    private Integer visits;

    @Column(name = "sales")
    private Integer sales;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date")
    private LocalDate date;

}
