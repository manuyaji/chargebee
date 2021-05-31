package com.yaji.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaji.demo.services.MathServices;

@RestController
@RequestMapping(path="/test")
public class TestController {
	
	@Autowired
	private MathServices mathServices;
	
	@RequestMapping(method=RequestMethod.GET, path="/subArrayEqualsSum")
	public List<Integer> getSubArrayEqualsSum(){
		int[] arr = {1,2,3,4,5};
		List<Integer> ret = mathServices.sumEqualsSubArray(8, arr);
		System.out.println(ret);
		return ret;
	}

}
