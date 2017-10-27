package com.airbnb.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.airbnb.web.command.Command;
import com.airbnb.web.domain.Board;
import com.airbnb.web.domain.Member;
import com.airbnb.web.mapper.BKMapper;
import com.airbnb.web.service.IGetService;



@RestController
public class BKController {
	private static final Logger logger = LoggerFactory.getLogger(BKController.class);
	@Autowired Member mem;
	@Autowired BKMapper mapper;
	@Autowired Board bod;
	
		
	
	@RequestMapping(value="/get/login",method=RequestMethod.POST)
	public @ResponseBody Map<?,?> put(@RequestBody Member mem){
		logger.info("BKController::::: BKController {}","컨트롤러진입");
		System.out.println("id : "+ mem.getMemberId()+"비번 : "+mem.getMemberPassword());
		Map<String,Object> map=new HashMap<>();
		Command cmd=new Command();
		cmd.setAction(mem.getMemberId());
		cmd.setColumn(mem.getMemberPassword());
		String result;		
		Member m=(Member) new IGetService() {
			
			@Override
			public Object execute(Object o) {
				// TODO Auto-generated method stub
				return mapper.selectOne(cmd);
			}
		}.execute(cmd);
		
		 if(m==null) {
	         result="fail";
	      }else {
	         result="success";
	      }
		
		
		System.out.println("통신후"+cmd.toString());
		System.out.println("통신후"+m.toString());
		map.put("member", m);
		
		return map;
	}

}