package com.zg.mapper;
import com.zg.pojo.IpAddressDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
;import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface IpAddressMapper {
   //查询ip的地址
   List<IpAddressDTO> selectIp(IpAddressDTO ipAddressDTO);
   //增加ip地址
   int insertIp(IpAddressDTO ipAddress);
}
