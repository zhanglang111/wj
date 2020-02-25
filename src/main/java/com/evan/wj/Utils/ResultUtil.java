package com.evan.wj.Utils;

/**
 * Code by langlang on 2020/2/25
 */
public class ResultUtil {
    public static Result OK(Object object) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result OK() {
        return OK(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
