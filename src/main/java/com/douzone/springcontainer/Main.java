package com.douzone.springcontainer;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {

	public static void main(String[] args) {
		// testBeanFactory();
		testApplicationContext();
	}

	public static void testBeanFactory() {
		// @설정인 경우 id가 자동으로 만들어진다. User1 =>user1
		// User1에서 아이디를 달아주면 그 아이디로
		BeanFactory bf1 = new XmlBeanFactory(new ClassPathResource("config/applicationContext2.xml"));

		User1 user = (User1) bf1.getBean("user1");
		// 다운캐스팅을 명시적으로
		System.out.println(user.getName());// user1아이디로 스캐닝되어 컨테이너 안에 잘 생성되었다.

		// XML 빈설정인 경우에는 id를 주지않으면 에러!
		// id 대신에 타입으로 빈을 가져 올 수 있다. 2
		BeanFactory bf2 = new XmlBeanFactory(new ClassPathResource("config/applicationContext.xml"));
		user = (User1) bf2.getBean("user1");
		// user = bf2.getBean(User1.class); 2
		System.out.println(user.getName());
	}

	public static void testApplicationContext() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");

		User1 user1 = (User1) ac.getBean(User1.class);
		System.out.println(user1.getName());

		// 오류: 빈설정은 id나 name 설정을 해야 한다.
		// user = (User1)ac.getBean("user1");
		// System.out.println(user.getName());

		// name으로 가져오기
		User user = (User) ac.getBean("user");
		System.out.println(user.getName());

		// id로 가져오기
		user = (User) ac.getBean("usr");
		System.out.println(user.getName());

		// User class타입이 두개여서 가져올때 무엇을 가지고 올지 모름
		// 오류 : 같은 타입의 빈이 2개이상 존재하면 타입으로 빈을 가져올 수 없다.
		// ac.getBean(User.class);
		
		User user2 = (User)ac.getBean("usr2");//기본 생성자를 만들어줘야된다.
		System.out.println(user2);
		
		User user3 = (User)ac.getBean("usr3");
		System.out.println(user3);
		
		Friend friend = (Friend)ac.getBean("friend");
		System.out.println(friend);
		
		User user4 = (User)ac.getBean("usr4");
		System.out.println(user4);
		
		
		
	}

}
