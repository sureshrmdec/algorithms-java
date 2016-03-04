package com.shulga.tc.s679.d1;

import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class FiringEmployees {
	
	public int fire(int[] manager, int[] salary, int[] productivity) {
		int totalProfit=0;
		for (int i = manager.length-1; i >=0 ; i--) {
			int profit = productivity[i] - salary[i];
			if(totalProfit+profit<0){
				totalProfit=0;
			}else{
				totalProfit+=profit;
			}

		}
		return totalProfit;
	}
}
