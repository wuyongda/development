package com.customer.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public class PageHelperUtils {

    public static <T> void startPage(Page<T> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
    }

}
