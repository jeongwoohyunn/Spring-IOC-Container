package com.douzone.springcontainer;

import org.springframework.stereotype.Component;

//스캐닝하기위해서는 ->컨테이너 안에 만들어짐
@Component
public class User1 {
	public String getName() {
		return "둘리1";
	}
}
