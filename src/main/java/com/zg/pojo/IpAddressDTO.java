package com.zg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IpAddressDTO {
	String ip;
	@DateTimeFormat(style = "yyyy-MM-dd")
	Date accessTime;
}
