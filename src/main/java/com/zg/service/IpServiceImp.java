package com.zg.service;
import com.zg.mapper.GoodsMapper;
import com.zg.mapper.IpAddressMapper;
import com.zg.pojo.EvaluateDTO;
import com.zg.pojo.GoodsDTO;
import com.zg.pojo.IpAddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IpServiceImp implements IpService {
    @Autowired
    IpAddressMapper ipAddressMapper;
    @Override
    public int ipAddressIntercepter(String ip, Date accessTime) {
        int rows = -1;
        IpAddressDTO ipAddress = new IpAddressDTO();
        ipAddress.setIp(ip);
        ipAddress.setAccessTime(accessTime);
        List<IpAddressDTO> ipList = ipAddressMapper.selectIp(ipAddress);
        System.out.println("这是行数：-----------"+ipList.size());
        if(ipList.isEmpty()) {
            //数据库没有就增加一条ip信息
            ipAddressMapper.insertIp(ipAddress);
            rows = 0;
        }
        return rows;
    }
}
