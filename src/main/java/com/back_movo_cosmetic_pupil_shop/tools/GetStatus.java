package com.back_movo_cosmetic_pupil_shop.tools;

import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

public class GetStatus {

    static public Map<String, Object> get(Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", data);
        if (data == null) {
            map.put("status", 500);
        } else {
            map.put("status", 200);
        }
        return map;
    }
}
