package com.evan.wj.Utils;

/**
 * Code by langlang on 2020/2/25
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * http请求返回的最外层对象
 * Created by wzh-zhua on 2018/10/1.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Result<T> {
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private T data;

}
