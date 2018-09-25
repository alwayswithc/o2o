 package com.imooc.myo2o.web.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "personadmin", method = { RequestMethod.GET })

/**
 * 主要用来解析路由并转发到相应的html中
 * 
 *
 */
public class personAdminController {
	@GetMapping("/regist")
	public String regist() {
		return "person/regist";
	}
	@RequestMapping("/login")
	public String login() {
		return "person/login";
	}
	
}
