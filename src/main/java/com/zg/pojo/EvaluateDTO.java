package com.zg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//评价表
public class EvaluateDTO {
    //评价id
    private String evaluateId;
    //商品id
    private String goodsId;
    //评价情况
    private String evaluateInfo;
    //评论分
    private Integer likeNum;
}
