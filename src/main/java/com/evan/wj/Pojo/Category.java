package com.evan.wj.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Code by langlang on 2020/2/22
 */
@Entity
@Data
@Table(name = "category")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })

@AllArgsConstructor
@NoArgsConstructor

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    String name;
}
