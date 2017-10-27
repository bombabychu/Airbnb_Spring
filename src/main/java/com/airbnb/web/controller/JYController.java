package com.airbnb.web.controller;

import java.util.HashMap;
import java.util.List;
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
import com.airbnb.web.domain.Member;
import com.airbnb.web.domain.Reservation;
import com.airbnb.web.mapper.JYMapper;
import com.airbnb.web.service.IGetService;
import com.airbnb.web.service.IListService;
import com.airbnb.web.service.IPostService;

@RestController
public class JYController {
	private static final Logger logger = LoggerFactory.getLogger(JYController.class);
	@Autowired JYMapper jyMapper;
	@Autowired Command cmd;
	@Autowired Reservation getRes;
	@Autowired Member mem;
	
	@RequestMapping(value="/go/login",method=RequestMethod.POST)
	public @ResponseBody Map<?,?> login(@RequestBody Member mem){
		logger.info("JYController: {}","진입");
		Map<String,Object> map=new HashMap<>();
		
		cmd.setAction(mem.getMemberId());
		cmd.setColumn(mem.getMemberPassword());
		
		String msg= "";		
		Member m=(Member) new IGetService() {			
			@Override
			public Object execute(Object o) {
				return jyMapper.selectOne(cmd);
			}
		}.execute(cmd);
		
		 if(m==null) {
			 msg="fail";
	      }else {
	    	  msg="success";
	      }

		System.out.println("통신후 cmd : "+cmd.toString());
		System.out.println("통신후 m : "+m.toString());
		
		map.put("member", m);
		map.put("msg", msg);
		
		return map;
	}
	
	@RequestMapping("/get/room/list")
	public @ResponseBody List<?> roomList(){
		logger.info("roomList Ctrl {}","진입");

		List<?> list = new IListService() {
			@Override
			public List<?> execute(Object o) {
				return jyMapper.selectList(cmd);
			}
		}.execute(null);
		return list;
	}
	@RequestMapping(value="/post/reservation",method=RequestMethod.POST)
	public @ResponseBody Map<?,?> addReservation(@RequestBody Reservation getRes){
		logger.info("addReservation Ctrl {}","진입");
		System.out.println("getRes JSON ! 잘 들어왔니? " + getRes);
		Map<String,String> map = new HashMap<String, String>();
		new IPostService() {
			@Override
			public void execute(Object o) {
				jyMapper.insert(getRes);
			}
		}.execute(null);
		map.put("msg", "통신 성공 했습니다.");
		return map;
	}
}
