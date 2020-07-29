package com.zg.tools;

import com.zg.service.IpService;
import com.zg.service.IpServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取用户Ip地址工具类
 * @author Administrator
 *
 */

public class IpAddressUtil {

	public static String getIpAddress(HttpServletRequest req) {
		String ip ="";
		
		//squid服务代理
		String ipAddress = req.getHeader("X-Forwarded-For");
		if(ipAddress == null||ipAddress.length() == 0||"unKnown".equalsIgnoreCase(ipAddress)){
			//apache服务代理
			ipAddress = req.getHeader("Proxy-client-IP");
		}
		if(ipAddress == null||ipAddress.length() == 0||"unKnown".equalsIgnoreCase(ipAddress)){
			//weblogic服务代理
			ipAddress = req.getHeader("WL-Proxy-Client-IP");
		}
		if(ipAddress == null||ipAddress.length() == 0||"unKnown".equalsIgnoreCase(ipAddress)){
			//有些代理
			ipAddress = req.getHeader("HTTP_CLIENT_IP");
		}
		if(ipAddress == null||ipAddress.length() == 0||"unKnown".equalsIgnoreCase(ipAddress)){
			//ngin服务代理
			ipAddress = req.getHeader("X-Real-IP");
		}
		if(ipAddress != null&&ipAddress.length()!=0){
			//如果是服务代理，获取的ip会有多个，取第一个
			ip = ipAddress.split(",")[0];
		}
		if(ip == null||ip.length() == 0||"unKnown".equalsIgnoreCase(ip)){
			//如果不是以上服务代理，只能通过getRemoteAddr()获取了
			ip = req.getRemoteAddr();
		}
		
		
		return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
	
}
