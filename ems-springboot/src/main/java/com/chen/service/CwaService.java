package com.chen.service;

import java.util.Map;


public interface CwaService {
    void insertCwa(Map<String, Object> cwa);

    void updateCwa(Map<String, Object> cwa);

    void updateCwaEnd(Map<String, Object> map);
}
