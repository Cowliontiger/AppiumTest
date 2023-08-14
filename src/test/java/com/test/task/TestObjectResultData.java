package com.test.task;

import java.util.ArrayList;
import java.util.List;

public class TestObjectResultData  {
	
	private int rowResult;
	private List<String> allPageResults;  //每页的结果
	private String finalResult = "";  //最终结果
	private String orderResult = "";  //订单结果
	private String extResult;    //扩展结果
	
	public TestObjectResultData() {
		super();
		allPageResults = new ArrayList<String>();
	}

	public void setRow(int row){
		rowResult = row; 
	}
	
	
	public void addPageResult(String result)
	{
		allPageResults.add(result);
	}
	
	public void setFinalResult(String result)
	{
		finalResult = result;
	}
	
	public void setOrderResult(String result)
	{
		orderResult = result;
	}
	
	public void setExtResult(String result)
	{
		extResult = result;
	}
	
	public List<String> getAllPageResults() {
		return allPageResults;
	}
	
	
	public String getFinalResult() {
		return finalResult;
	}
	
	public String getOrderResult() {
		return orderResult;
	}
	
	public int getRow(){
		return rowResult;
	}
	
	public String getExtResult() {
		return extResult;
	}

}
