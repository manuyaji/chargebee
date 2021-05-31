package com.yaji.demo.services;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MathServicesTest {
	
	@Autowired MathServices mathServices;
	
	@Test
	public void testSumEqualsSubArray(){
		int[] arr = {1,2,3,4,5};
		int[] retArr = new int[]{3,5};
		List ret = Arrays.asList(retArr);
		Assertions.assertEquals(ret, mathServices.sumEqualsSubArray2(new int[]{1,2,3,4,5}, 8));
		
		//new MathServices().sumEqualsSubArray(8,arr);
	}

}
