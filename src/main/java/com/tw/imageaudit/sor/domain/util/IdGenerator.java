package com.tw.imageaudit.sor.domain.util;

import java.util.UUID;

/**
 * @author hf_cherish
 * @date 4/9/18
 */
public class IdGenerator {
    public static String next() {
        return UUID.randomUUID().toString();
    }
}
