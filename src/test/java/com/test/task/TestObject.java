package com.test.task;

import java.io.File;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.test.pages.MappingExcel;

import com.test.tools.CreatAndReadExcel;
import io.appium.java_client.MobileElement;
import junit.framework.TestCase;
import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import com.test.pages.BasePage;
import com.test.tools.CallURl;
import com.test.tools.SdkDB2;
import com.test.tools.tool;
import org.openqa.selenium.TakesScreenshot;

public class TestObject{
	public String [] lines; //每行的数据 包含：0行号  1测试数据  2预测结果  3序列号 4扩展信息 5重置
	public int row;
	public String serienum;
	public String ext;
	public int reset;
	public String  testType;
	public String  predict;
	public String[]  predicts;
	public int flag;
	public static String orderId;
	public static String WEIXIN_PUBLIC_ACCOUNT = "公众号";
	public static String WEIXIN_MINI_PROGRAM = "小程序";
	
	public TestObject(List<Object> data) {
		super();
			
		this.row = Integer.parseInt(data.get(0).toString());
		this.lines = data.get(1).toString().split("\n");
		this.predict = data.get(2).toString();
		this.serienum = data.get(3).toString();
		this.ext = data.get(4).toString();
		this.reset = Integer.parseInt(data.get(5).toString());
		this.testType = data.get(6).toString();
	}

	private String[] classNames = {"Page0","Page1","Page2","Page3","Page4","Page5","Page6"};
	
	public TestObjectResultData runTest() {
		List<BasePage> pages = new ArrayList<BasePage>();
		List<MappingExcel> alist = null;
		if(lines.length > 0 && lines != null && !lines.equals("")){


			//根据实际流程去加载页面
			for(int i = 0;i<lines.length;i++) {
				//System.out.println("lines[i]:"+lines[i]);
				if(lines[i] != ""){
					String [] a = new String[30];
					String [] b = new String[30];
					//先取出每行数据的前置类名，如Explore:等
					String clazz = lines[i].split(":")[0].toString();
					String line = lines[i].split(":")[1].toString();
					line = lines[i].replace("|", "#");
				    String[] atts = line.substring(0,line.length() - 1).split(":")[1].split("#", -1);
				    for(int j=0;j<atts.length;j++){
			            a[j]=atts[j];
			        }
				    try{
				    	Class classType = Class.forName("com.test.pages." + clazz);
				        Constructor<BasePage>c1 = classType.getDeclaredConstructor(int.class,String[].class);

						for(int k = 0 ; k < atts.length ; k++) {
							//通过测试用例的sheet0得到name后，再通过对照表sheet1查询得到对应的value与type
							MappingExcel me = getMappingTableByName(a[k]);
							//数组a[0]数据结构为 value~~type
							//例如，android:id/button1~~id
							b[k] = me.getValue() + "~~" + me.getType();

						}
						BasePage obj = c1.newInstance(i, tool.deleteArrayNull(b));
						pages.add(obj);
				    }
				    catch(Exception e) {
				     	e.printStackTrace();
				    }
				}
			}

		}
		
		TestObjectResultData data = new TestObjectResultData();
		
		data.setRow(row);
		
		String result = "";
		
		if(pages.size() != 0){
			
			if(reset == 1){
				try {
					//new SdkDB2().UImsi(reset);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for(BasePage page : pages)
			{
				try {
					//if(page.page == 1){
//						//System.out.println("1:"+By.id(Entry.packageName+":id/merchOrderId"));
//						//System.out.println("2:"+Entry.driver.findElement(By.id(Entry.packageName+":id/merchOrderId")).getText());
//						orderId = Entry.driver.findElement(By.id(Entry.packageName+":id/merchOrderId")).getText();
					//}
					System.out.println("page:"+page.page);
					tool.sleep(2000);
					page.renderUIPage();
					//Entry.driver.getContextHandles();
					//Entry.driver.context("NATIVE_APP");
					//Entry.driver.context("WEBVIEW");
					tool.snapshot(Entry.driver, "./test-output/"+ Entry.dataTime +"/" + serienum +"_"+page.page +".png" );
					data.addPageResult(page.page + ".成功\n");
					result = "成功";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					result = "失败";
					data.addPageResult(page.page +".失败\n");
					//System.out.println(page.page + ".失败");
					break;
				}
			}
			
//			if(predict.contains("select") || predict.contains("SELECT")){
//				tool.sleep(1000);
//				try {
//					System.out.println(predict.substring(0,predict.indexOf("#")));
//					//result = new SdkDB2().UPredictformation(predict.substring(0,predict.indexOf("#")));
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//
//				}
//				predict = predict.substring(predict.indexOf("#")+1,predict.length()-1);
//				predicts = predict.split("\\|");
//			}

			//predict = predict.substring(predict.indexOf("#")+1,predict.length()-1);
			predicts = predict.split("\\|");
			if(result.indexOf(".") > -1) {
				data.addPageResult(result);
			}
			//if(!result.equals("")){
				for(int i = 0;i<predicts.length;i++){
					if(result.contains(predicts[i])) flag = 1;
					else{
						flag = 0;
						break;
					}
				}
				if(predict.contains(result)) {
					data.setFinalResult("测试通过");
				}
				else if(flag == 1) {
					data.setFinalResult("测试通过");
				}
				else {
					data.setFinalResult("测试不通过");
				}

//				data.setFinalResult(predict.contains(result) ? "通过":"失败");
//			}
//			else {
//				data.setFinalResult("测试不通过");
//			}
		}
		
		try {
			
			if(orderId != null)  	data.setOrderResult(new SdkDB2().UOrderInformation(orderId));		
			//if((ext != ""))  data.setExtResult(new SdkDB2().UExtendInformation(ext));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		orderId = null;
		return data;
	}

	public static MappingExcel getMappingTableByName(String st){
		//读取对照表内容
		MappingExcel me = new MappingExcel();
		List<MappingExcel> alist = null;
		try {
			alist = CreatAndReadExcel.read2007Excel4EvkAPPTestCase(1, new File(System.getProperty("user.dir")), Entry.excelName);
			//System.out.println("alist.get:"+alist.size());
			for(int i = 0 ; i < alist.size() ; i++) {
				List<String> str = new ArrayList<>();
				str.add(st);
				//System.out.println("test:"+alist.get(i).getName());
				alist = alist.stream().filter(MappingExcel -> str.contains(MappingExcel.getName())).collect(Collectors.toList());
				alist.forEach(MappingExcel -> {
					//System.out.println(MappingExcel.getValue());
					//System.out.println(MappingExcel.getType());
					me.setValue(MappingExcel.getValue());
					me.setType(MappingExcel.getType());
				});
			}
		}	catch (Exception e){
			e.printStackTrace();
		}
		return me;
	}
}
