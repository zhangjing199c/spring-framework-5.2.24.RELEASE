package cn.zj.ioc.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Tiger {
	private String name;
	private Integer age;
	public Tiger() {
		System.out.println("Tiger...");
	}
}
