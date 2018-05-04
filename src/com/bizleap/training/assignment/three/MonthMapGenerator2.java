package com.bizleap.training.assignment.three;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class MonthMapGenerator2 {
	private Map<Integer,Object> monthMap=new HashMap<Integer,Object>();
	
	private class Month{
		private String name;
		private int numberOfDays,year;
		
		public Month(int year,String name,int numberOfDays){
		
			this.name = name;
			this.numberOfDays = numberOfDays;
			this.year = year;
	    }
        
		public String toString(){
			return this.numberOfDays+"/"+this.name+"/"+this.year;
		}
   }
	
	private boolean isValid(int year){
		return year >= 0;
	}
	
	private boolean isValid(int fromYear,int toYear){
		return !(fromYear<=0||toYear<=0||fromYear>toYear);
	}
	
	public boolean isLeapYear(int year){
		return year%400 == 0;
	}
	
	private List<Month> createMonthsForYear(int year){
		List<Month> monthList=new ArrayList<Month>();
		monthList.add(new Month(year,"January",31));
  		monthList.add(new Month(year,"March",31));
  		monthList.add(new Month(year,"May",31));
  		monthList.add(new Month(year,"July",31));
 	  	monthList.add(new Month(year,"Augest",31));
 	  	monthList.add(new Month(year,"September",31));
 	  	
 	  	monthList.add(new Month(year,"October",31));
  		monthList.add(new Month(year,"April",30));
  		monthList.add(new Month(year,"June",30));
  		monthList.add(new Month(year,"November",30));
  		
  		if((year%400)==0)
  		   {
  			monthList.add(new Month(year,"February",29));
  	       }else {
  	    	monthList.add(new Month(year,"February",28));
  	       }
  		return monthList;
	}
	
	public Map<Integer,Object> createMonthMap(int year){
		if(isValid(year)){
			for(Month month:createMonthsForYear(year)){
				addMonthToMap(month);
			}
		}
			else{
				monthMap.put(year, "Year is invalid");
			}
			return monthMap;
	}
	
	public Map<Integer,Object> createMonthMap(int fromYear,int toYear){
		if(isValid(fromYear,toYear)){
			   for(int year=fromYear;year<=toYear;year++){
				   createMonthMap(year);
			   }
		 }else{
			   monthMap.put(fromYear,"Range or years are invalid");
			   monthMap.put(toYear,"Range or years are invalid");
		 }
			return monthMap;
	}
	
	public List<Month>createMonthsForYearRange(int fromYear,int toYear){
		List<Month> monthList=new ArrayList<Month>();
		for(int year=fromYear;year<=toYear;year++){
			monthList.addAll(createMonthsForYear(year));
		}
		return monthList;
	}
	
	public Map<Integer,Object>createMonthMapRange(int fromYear,int toYear){
		if(isValid(fromYear,toYear)){
			for(Month month:createMonthsForYearRange(fromYear,toYear)){
				addMonthToMap(month);
			}
		}else{
			monthMap.put(fromYear,"Range or years are invalid");
			monthMap.put(toYear,"Range or years are invalid");
		}
		return monthMap;
	}
	
	private void addMonthToMap(Month month){
		List<Month> monthList=(List<Month>) monthMap.get(month.numberOfDays);
		if(monthList!=null)
			monthList.add(month);
		else{
			monthList=new ArrayList<Month>();
			monthList.add(month);
			monthMap.put(month.numberOfDays,monthList);
		}
	}
	
	public void prettyPrint(Map<Integer,Object> monthMap){
		for(Map.Entry<Integer,Object> entry:monthMap.entrySet())
		{
			System.out.println("Key:"+entry.getKey());
		    System.out.println(entry.getValue().toString());
		    System.out.println();
		}
		System.out.println("--------------------");
	}
	
	public static void main(String args[]){
		MonthMapGenerator2 monthMapGenerator=new MonthMapGenerator2();
		Map<Integer,Object> monthMap=monthMapGenerator.createMonthMap(2000);
		monthMapGenerator.prettyPrint(monthMap);
	}
}

	

	
