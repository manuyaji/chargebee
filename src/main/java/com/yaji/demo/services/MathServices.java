package com.yaji.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MathServices {
	
	private int[] getRemainingArr(int[] arr, int indexToRemove){
		int[] ret = new int[arr.length-indexToRemove-1];
		//System.out.println(indexToRemove);
		int cnt = 0;
		for(int i=indexToRemove+1; i<ret.length; i++){
			ret[cnt++] = arr[i];
		}
		printArr(ret);
		return ret;
	}


	public List<Integer> sumEqualsSubArray(int sum, int[] arr){
		List<Integer> ret = new ArrayList<>();
		if(sum == 0){
			return ret;
		}
		if(arr == null || arr.length == 0){
			return null;
		}
		for(int i=0; i<arr.length; i++){
			if(arr[i] == sum){
				ret.add(arr[i]);
				return ret;
			} else if(arr[i] < sum) {
				List<Integer> downstreamList = sumEqualsSubArray(sum - arr[i], getRemainingArr(arr, i));
				printArr(arr);
				System.out.println("index : "+arr[i]+ " ; downstrema: "+downstreamList);
				if(downstreamList == null){
					continue;
				} else {
					ret.addAll(downstreamList);
					ret.add(arr[i]);
					return ret;
				}
			}
		}
		return null;
	}
	
	public void printArr(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+",");
		}
		System.out.println();
	}
	
	public static void main (String args[]){
		int[] arr = {1,2,3,4,5};
		System.out.println(new MathServices().sumEqualsSubArray(8,arr));
	}
	
	
	public List<Integer> sumEqualsSubArray2(int[] arr, int sum){
		List<Integer> ret = new ArrayList<>();
		if(sum == 0){
			return ret;
		}
		if(arr == null || arr.length == 0){
			return null;
		}
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length; j++){
				if(arr[i] + arr[j] == sum){
					ret.add(arr[i]);
					ret.add(arr[j]);
					return ret;
				}
			}
		}
		return null;
	}
	
	
	
	// 1,2,3,4,5  8
		// 2's combination:
		// 3's combo
		// 4's combo
		// ...
		// n's combo
	
	public List<Integer> sumEqualsSubArrayN(int[] arr, int sum){
		List<Integer> ret = new ArrayList<>();
		if(sum == 0){
			return ret;
		}
		if(arr == null || arr.length == 0){
			return null;
		}
		// how many combinations
		for(int i=1; i<=arr.length; i++){
			List<List<Integer>> combos = generateCombinations(arr, i);
			for(List<Integer> each: combos){
				int curSum = 0;
				for(Integer e: each){
					curSum+= e;
				}
				if(curSum == sum){
					return each;
				}
			}
		}
		return null;
	}
	
	public List<List<Integer>> generateCombinations(int[] arr, int numCombos){
		List<List<Integer>> ret = new ArrayList<>();
		return ret;
	}
	
	
	

}
