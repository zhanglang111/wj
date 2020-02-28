package com.evan.wj.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Code by langlang on 2020/2/26
 */
@Data
@Entity
@Table(name = "admin_menu")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String path;
    String name;
    String nameZh;
    String iconCls;
    String component;
    int parentId;

    @Transient
    private List<AdminMenu> children;
}
