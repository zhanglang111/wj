package com.evan.wj.Utils;

import org.springframework.context.annotation.Bean;

import java.util.Random;

/**
 * Code by langlang on 2020/2/24
 */

public class PictureUtil {

    public String CreatePicUrlRomdomnNumString(int length){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
