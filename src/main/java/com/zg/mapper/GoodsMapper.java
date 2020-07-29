package com.zg.mapper;

import com.zg.pojo.EvaluateDTO;
import com.zg.pojo.GoodsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface GoodsMapper {
    //查询数据
    List<GoodsDTO> queryGoodsList();
    //添加一条评价
    int getInsertEvaluate(EvaluateDTO evaluateDTO);
    //删除
    int getDeleteGoods(String id);
    //增加
    int getInsertGoods(GoodsDTO goodsDTO);
    //查询到一个goodsId用户名
    @Select("select goodsId from goods where goodsId = #{goodsId}")
    List<GoodsDTO>  getGoods(String name);
}
