package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVo;

@RestController
@RequestMapping("/sample")
public class SampleController {

	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
	
	@RequestMapping("/sendVo")
	public SampleVo sendVo() {
		SampleVo vo = new SampleVo();
		vo.setFirstName("길동");
		vo.setLastName("홍");
		vo.setMno(333);
		
		return vo;
	}
	
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Object> sendListAyth(){
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<SampleVo>> sendListNot(){
		List<SampleVo> list = new ArrayList<>();
		for(int i=0; i<10; i++) {
			SampleVo vo = new SampleVo();
			vo.setFirstName("깅동");
			vo.setLastName("홍");
			vo.setMno(i);
			list.add(vo);
		}
		return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
	}
}
