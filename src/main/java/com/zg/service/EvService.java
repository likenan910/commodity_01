package com.zg.service;

import org.apache.ibatis.annotations.Param;

public interface EvService {
    public Double getGoodsAvg(@Param("id") String id);
}
