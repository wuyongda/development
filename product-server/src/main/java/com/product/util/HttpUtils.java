package com.product.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class HttpUtils {

    /**
     * 
     * 功能:通过HttpServletResponse向前端输出json数据<br>
     * @param response
     * @param t
     * @throws IOException
     */
    public static <T> void responseOutWithJson(HttpServletResponse response, T t) throws IOException {
        // 设置字符编码格式
        response.setCharacterEncoding("UTF-8");
        // 设置数据格式
        response.setContentType("application/json; charset=utf-8");
        // 想前端输出数据
        response.getWriter().write(JSON.toJSONString(t));
    }

}
