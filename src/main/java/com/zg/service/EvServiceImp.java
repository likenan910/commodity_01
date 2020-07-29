package com.zg.service;

import com.zg.mapper.EvaluateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvServiceImp implements EvService {
    @Autowired
    EvaluateMapper evaluateMapper;
    @Override
    //平均分
    public Double getGoodsAvg(String id) {
        Double likeNum = evaluateMapper.EvaluateAvg(id);
        return likeNum;
    }
}
