package cn.zj.ioc.bean;

//@Component
public class Dog {
	private String name;
	private Integer age;
	public Dog() {
		System.out.println("Dog...");
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
