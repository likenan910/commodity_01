package com.zg.service;

import com.zg.pojo.EvaluateDTO;
import com.zg.pojo.GoodsDTO;
import com.zg.pojo.IpAddressDTO;

import java.util.Date;

public interface IpService {
    //拦截ip
    public int ipAddressIntercepter(String ip, Date accessTime);
}
