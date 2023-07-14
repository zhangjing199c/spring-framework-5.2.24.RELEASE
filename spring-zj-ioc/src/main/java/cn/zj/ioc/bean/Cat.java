package cn.zj.ioc.bean;

import org.springframework.stereotype.Component;

@Component
public class Cat {
	private String name;
	private Integer age;

	public Cat() {
		System.out.println("Cat...");
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
