package com.product.util;

public class KeyGeneratorUtil {

    // Twitter_Snowflake 雪花算法
    private static final SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0, 0);
    
    /**
     * 获取Long类型的随机数
     * @return
     */
    public static long getNextLong() {
        return snowflakeIdWorker.nextId();
    }
}
