package com.test.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.By;

import com.test.task.Entry;
import com.test.task.TestObject;

public class SdkDB2 {

	Connection conn = null;
	
	public static void main(String []  args) throws SQLException{
		

		
		String a = "  y  n";
		a.trim();
		String regex = "\\s+";
		String str1 = a.replaceAll(regex, "");
		System.out.println(a);
		//new SdkDB2().UImsi("1");
		
//		String a = "select STATUS from T_ORDER_INFO where MERCH_ORDER_ID='orderID'#02,06#";
////		String a = "select STATUS from T_ORDER_INFO where MERCH_ORDER_ID='1513071989224'";
//		String result = new SdkDB2().UPredictformation(
//				"select CHN_ERR_CODE from T_ORDER_INFO where MERCH_ORDER_ID='orderID'");
//		System.out.println(result);
//		new SdkDB2().UImsi(1);
//		System.out.println( new SdkDB2().UExtendInformation("delete  from T_RISK_CHECK_DOUBT_MERCH where MERCHANT_ID='502053000186' and INDUSTRY_ID ='11' |delete from T_RISK_CHECK_DOUBT where  INDUSTRY_ID='11' and DOUBT_TYPE='2'|insert into T_RISK_CHECK_DOUBT (DOUBT_ID, DOUBT_PARAM, INDUSTRY_ID,SCALE,DOUBT_TYPE,DOUBT_DESC,DOUBT_CLASS,ADD_TIME,STATUS) values('MacUseCardsDay','2','11','0','2',' 当天同一设备交易银行卡超xx张(含交易失败) ','com.payeco.ppi.risk.doubt.MacUseCardsDay',to_date('2017/12/4 15:35:58','yyyy/mm/dd hh24:mi:ss'),'1')|UPCALL: http://10.123.1.41:9080/ppi/TorukInit"));       	
//		System.out.println(new CallURl().getURLContent("UPCALL: http://10.123.1.41:9080/ppi/TorukInit".replace("UPCALL:", "")));
		//System.out.println(new SdkDB2().UOrderInformation("1485137172657"));
	}
	/**
	 * 链接数据库
	 */
	public Connection DB2Statement() {
		
		Properties properties = new Properties();
		properties.setProperty("user", "db2scadm");
		properties.setProperty("password", "system!@#$QWER");
		properties.setProperty("currentSchema", "PPI");
		
		try {
			// 驱动程序名
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			conn = DriverManager.getConnection("jdbc:db2://10.123.1.44:50000/PAYECO", properties);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return conn;
}

	/**
	 * 修改UImsi地址
	 */
	public void UImsi(int i)throws SQLException {
		Statement st = this.DB2Statement().createStatement();
		ResultSet rs = null;
		try {
			if (i == 1 ) {
				String sql2 = "update T_USER_BANK_ACC set IMSI='3102600000000002' where IMSI = '310260000000000'";
			    st.executeUpdate(sql2);
			    System.out.println("重置已执行");
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (st == null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	/**
	 * 查询订单信息
	 * @throws SQLException 
	 */
	public String UOrderInformation(String id) throws SQLException {
		Statement st = this.DB2Statement().createStatement();
		ResultSet rs = null;
		String result = "";
		
		try {
			String sql2 ="select * from T_ORDER_INFO_"+tool.getDate()+" where MERCH_ORDER_ID='"+id+"'";
			rs = st.executeQuery(sql2);
			while (rs.next()) {
				String uid=rs.getString("MERCHANT_ID");
				String userid=rs.getString("MERCH_ORDER_ID");
				String de=rs.getString("ORDER_TIME");
				result = "商户号："+uid+"  商户订单号："+userid+"  商户订单时间："+de;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (st == null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return result;
	}
	
		
	
//	/**
//	 * 查询预测结果
//	 * @throws SQLException
//	 */
//	public String UPredictformation(String res) throws SQLException {
//		Statement st = this.DB2Statement().createStatement();
//		ResultSet rs = null;
//		String result = "";
//
//		try {
//			if(res.contains("orderID")){
//				res = res.replace("orderID", TestObject.orderId);
//			}
//
//			if(res.contains("@OrderDate")){
//				res = res.replace("@OrderDate", tool.getDate());
//			}
//
//			rs = st.executeQuery(res);
//
//			int columnNum = rs.getMetaData().getColumnCount();
//			if (rs.next()) {
//				for (int k = 1; k < columnNum + 1; k++) {
//					result += rs.getObject(k);
//				}
//			} else {
//				System.out.println("没有数据");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (rs != null) {
//				rs.close();
//			}
//			if (st == null) {
//				st.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		return result;
//	}
	
//	/**
//	 * 查询扩展信息
//	 * @return sql 查询语句 str:sql1|sql2 result:1,2;3,4;5,6|456
//	 * @throws SQLException
//	 */
//	public String UExtendInformation(String str) throws SQLException {
//		ResultSet rs = null;
//		String result = "";
//
//		if (str != null && !str.equals("")) {
//
//			Statement st = this.DB2Statement().createStatement();
//
//			String [] aa = str.split("\\|");
//			for (int i = 0; i < aa.length; i++) {
//				try {
//					if(aa[i].contains("orderID")){
//						aa[i] = aa[i].replace("orderID", TestObject.orderId);
//					}
//            		String regex = "\\s+";
//            		String str1= aa[i].replaceAll(regex, "");
//
//                    if(aa[i].contains("UPCALL")){
//						result += new CallURl().getURLContent(aa[i].replace("UPCALL:", ""));
//					}else{
//						if(str1.charAt(0) == 's' || str1.charAt(0) == 'S'){
//							try {
//								 rs = st.executeQuery(aa[i]);
//							} catch (Exception e) {
//								// TODO Auto-generated catch block
//								System.out.println("error:数据库字段有误！");
//								e.printStackTrace();
//							}
//							int columnNum = rs.getMetaData().getColumnCount();
//
//							if (rs.next()) {
//								for (int k = 1; k < columnNum + 1; k++) {
//									result += rs.getObject(k) + ";";
//								}
//							} else {
//								System.out.println("没有数据");
//							}
//						}else if(str1.charAt(0) == 'd' || str1.charAt(0) == 'D' ||
//								str1.charAt(2) == 'd' || str1.charAt(2) == 'D'){
//							if(aa[i].contains("where") || aa[i].contains("WHERE") ){
//								result += String.valueOf(st.executeUpdate(aa[i]));
//							}else{
//								result += "没有where，不执行";
//							}
//						}else {
//							result += String.valueOf(st.executeUpdate(aa[i]));
//						}
//					}
//
//					result += "|" ;
//				} catch (SQLException e) {
//
//					conn.rollback();
//					e.printStackTrace();
//
//				}finally{
//					if (rs != null) {
//						rs.close();
//					}
//				}
//			}
//			st.close();
//			System.out.println(result);
//
//		}
//
//		conn.close();
//		return result;
//	}
}
