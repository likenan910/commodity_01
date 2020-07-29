package com.zg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//商品信息表
public class GoodsDTO {
    //商品Id
    private String goodsId;
    //商品名字
    private String goodsName;
    //商品描述
    private String goodsInfo;
    //打分
    private Integer fiveStars;
    //平均分
    private double avg;
}
