package cn.zj.ioc.bean;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
public class Rat {
	private String name;
	private Integer age;
	public Rat() {
		System.out.println("Rat...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
