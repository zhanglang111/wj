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
@Table(name = "admin_role")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    @Column(name = "name_zh")
    private String nameZh;
    private boolean enabled;
    @Transient
    private List<AdminPermission> perms;
    @Transient
    private List<AdminMenu> menus;
}
