package com.evan.wj.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * Code by langlang on 2020/2/22
 */
@Entity
@Data
@Table(name = "book")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;

    String cover;
    String title;
    String author;
    String date;
    String press;
    String abs;
}
