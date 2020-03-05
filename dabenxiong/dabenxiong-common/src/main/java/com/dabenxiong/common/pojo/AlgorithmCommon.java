package com.dabenxiong.common.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author 一只大笨熊
 * @create 2020-02-28 14:55
 */
public class AlgorithmCommon {

    public String Datetimenow(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  df.format(new Date());
    };
    public static Integer getNum(int digit) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < digit; i++) {
            if (i == 0 && digit > 1)
                str.append(new Random().nextInt(9) + 1);
            else
                str.append(new Random().nextInt(10));
        }
        return Integer.valueOf(str.toString());
    }

}
