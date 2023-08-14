package com.test.tools;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.TouchAction;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class tool {
	/**
	 * 截图
	 *
	 * @param drivername
	 * @param filename   截图文件保存路径
	 */
	public static void snapshot(TakesScreenshot drivername, String filename) {

		File screenShotFile = drivername.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取当前时间
	 */
	public static String getDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
		return df.format(new Date());
	}


	/**
	 * 滑动屏幕到底部
	 *
	 * @param driver
	 * @param during 滑动时间/毫秒
	 */
	public static void swipeToUp(AppiumDriver driver, int during) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width / 2, height * 6 / 7, width / 2, height / 7, during);
	}

	/**
	 * 滑动屏幕到某一位置
	 *
	 * @param driver
	 * @param x1     始宽
	 * @param y1     始长
	 * @param x2     末宽
	 * @param y2     末长
	 * @param during 滑动时间/毫秒
	 */
	public static void swipeTo(AppiumDriver driver, int x1, int y1, int x2, int y2, int during) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
//	    	driver.swipe(width * x1, height * y1, width * x2, height * y2, during);
		driver.swipe(width / 2, height * 6 / 8, width / 2, height * 5 / 8, during);
	}

	/**
	 * 等待
	 *
	 * @param during 等待时间/毫秒
	 */
	public static void sleep(int during) {
		try {
			Thread.sleep(during);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 隐式等待
	 *
	 * @param driver
	 * @param during 等待时间/秒
	 */
	public static void waitA(AppiumDriver driver, int during) {
		driver.manage().timeouts().implicitlyWait(during, TimeUnit.SECONDS);
	}

	/**
	 * 切换输入法为adb
	 */
	public static void switchToAdb() {

		try {
			Runtime.getRuntime().exec("adb shell settings put secure default_input_method com.android.adbkeyboard/.adbIME").waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 输入中文
	 *
	 * @param key 输入内容
	 */
	public static void inputCH(String key) {

		try {
			Runtime.getRuntime().exec("adb shell am broadcast -a adb_INPUT_TEXT --es msg " + key).waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 输入非中文
	 *
	 * @param key 输入内容
	 */
	public static void inputEN(String key) {

		try {
			Runtime.getRuntime().exec("adb -s emulator-5554 shell input text " + key).waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 清空
	 *
	 * @param driver
	 * @param text   删除内容
	 */
	public static void clearText(AndroidDriver driver, String text) {
		driver.pressKeyCode(123);
		for (int i = 0; i < text.length(); i++) {
			driver.pressKeyCode(67);
		}
	}

	public static List<File> filelist = new ArrayList<File>();

	public static List<File> getFileList(String strPath) {
		File dir = new File(strPath);
		File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i].getName();
				if (files[i].isDirectory()) { // 判断是文件还是文件夹
					getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
				} else if (fileName.endsWith("xlsx") || fileName.endsWith("xls")) { // 判断文件名是否以.avi结尾
					if (!fileName.startsWith("~")) {
						String strFileName = files[i].getAbsolutePath();
						//System.out.println("---" + strFileName);
						filelist.add(files[i]);
					}
				} else {
					continue;
				}
			}
		}
		return filelist;
	}


	public static void swipeUp(AndroidDriver driver) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		TouchAction action1 = new TouchAction(driver).press(width / 2, height * 4 / 5).waitAction().moveTo(width / 2, height / 4).release();
		action1.perform();
	}

	public static void swipeDown(AndroidDriver driver) {// scroll down to refresh
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		TouchAction action1 = new TouchAction(driver).press(width / 2, height / 4).waitAction().moveTo(width / 2, height * 3 / 4).release();
		action1.perform();
	}

	public static void swipeLeft(AndroidDriver driver) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		TouchAction action1 = new TouchAction(driver).press(width - 10, height / 2).waitAction().moveTo(width / 4, height / 2).release();
		action1.perform();
	}

	public static void swipeRight(AndroidDriver driver) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		TouchAction action1 = new TouchAction(driver).press(10, height / 2).waitAction().moveTo(width * 3 / 4 + 10, height / 2).release();
		action1.perform();
	}

	//页面不断上滑，滑动到出现 THE END为止
	public static void swipeToEnd(AndroidDriver driver) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		boolean isSwipe = true;
		String endString = "THE END";
		while (isSwipe) {
			swipeUp(driver);//向上滑动屏幕
			String temp = driver.getPageSource();
			if (temp.contains(endString))
				isSwipe = false;
		}
	}

	public static int findCount(String src, String des) {
		int index = 0;
		int count = 0;
		while ((index = src.indexOf(des, index)) != -1) {
			count++;
			index = index + des.length();
		}
		return count;
	}


	/***
	 * 去除String数组中的空值
	 */
	public static String[] deleteArrayNull(String string[]) {
		String strArr[] = string;

		// step1: 定义一个list列表，并循环赋值
		ArrayList<String> strList = new ArrayList<String>();
		for (int i = 0; i < strArr.length; i++) {
			strList.add(strArr[i]);
		}

		// step2: 删除list列表中所有的空值
		while (strList.remove(null));
		while (strList.remove(""));

		// step3: 把list列表转换给一个新定义的中间数组，并赋值给它
		String strArrLast[] = strList.toArray(new String[strList.size()]);

		return strArrLast;
	}
}
