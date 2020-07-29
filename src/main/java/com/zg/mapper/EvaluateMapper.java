package com.zg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EvaluateMapper {
    //获取平均分
    @Select("select avg(likeNum) from evaluate where goodsId=#{goodsId}")
    public Double EvaluateAvg(String id);
}
