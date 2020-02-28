package com.evan.wj.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * Code by langlang on 2020/2/26
 */
@Data
@Entity
@Table(name = "admin_user_role")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int uid;
    private int rid;
}
