package com.imooc.myo2o.web.person;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.myo2o.dto.PersonExecution;
import com.imooc.myo2o.entity.PersonInfo;
import com.imooc.myo2o.enums.PersonStateEnum;
import com.imooc.myo2o.exception.PersonOperationException;
import com.imooc.myo2o.service.PersonService;
import com.imooc.myo2o.util.CodeUtil;
import com.imooc.myo2o.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/person")
public class PersonManagementController {
	@Autowired
	PersonService personService;

	@ResponseBody
	@PostMapping("/regist")
	public Map<String, Object> registPerson(HttpServletRequest request) {

		Map<String, Object> modelMap = new HashMap<String, Object>();
		if (!CodeUtil.checkVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "输入了错误的验证码");
			return modelMap;
		}
		String personStr = HttpServletRequestUtil.getString(request, "personStr");
		ObjectMapper mapper = new ObjectMapper();
		PersonInfo person = null;
		try {
			person = mapper.readValue(personStr, PersonInfo.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		PersonExecution pe;
		try {
			pe = personService.addPerson(person);
			if (pe.getState() == PersonStateEnum.SUCCESS.getState()) {
				modelMap.put("success", true);
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", pe.getStateInfo());
			}
		} catch (PersonOperationException e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
		}
		return modelMap;

	}
	@ResponseBody
	@PostMapping("/login")
	public ModelMap login(HttpServletRequest request) {
		System.out.println("==================="); 
		ModelMap modelMap=new ModelMap();
		String name = HttpServletRequestUtil.getString(request, "name");
		String pwd = HttpServletRequestUtil.getString(request, "password");
		String userType = HttpServletRequestUtil.getString(request, "userType");
		PersonExecution pe;
		try {
			pe = personService.queryPersonByNameAndPwd(name, pwd);
			if (pe.getPerson() != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", pe.getPerson());
			} else {
				modelMap.addAttribute("success", false);
				modelMap.addAttribute("errMsg", pe.getStateInfo());
				
			}
		} catch (PersonOperationException e) { 
			modelMap.addAttribute("success", false);
			modelMap.addAttribute("errMsg", e.getMessage());
		}
		modelMap.addAttribute("success", true);
		if (userType.equals("1")) {
			modelMap.addAttribute("url","/myO2O/frontend/index");
		}else {
			modelMap.addAttribute("url","/myO2O/shopadmin/shoplist");
		}
		return modelMap;
	}
	@ResponseBody
	@PostMapping("/logout")
	public Map<String, Object> logout(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 将用户session置为空
		request.getSession().setAttribute("user", null);
		modelMap.put("success", true);
		return modelMap;
	}
	
}
