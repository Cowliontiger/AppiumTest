package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Test {

    public static void main(String[] args) throws Exception {
        test(1);
        test(2);
    }

    public static long test(int flag)  throws Exception {
        long aaa = 0;

        AndroidDriver driver;
        DesiredCapabilities cap=new DesiredCapabilities();

        cap.setCapability("automationName", "Appium");//appium做自动化
//    cap.setCapability("app", "C:\\software\\jrtt.apk");//安装apk
//    cap.setCapability("browserName", "chrome");//设置HTML5的自动化，打开谷歌浏览器
        cap.setCapability("deviceName", "192.168.20.104:5555");//设备名称
        cap.setCapability("platformName", "Android"); //安卓自动化还是IOS自动化
        cap.setCapability("platformVersion", "7.1.2"); //安卓操作系统版本
//        cap.setCapability("udid", "192.168.56.101:5555"); //设备的udid (adb devices 查看到的)
        cap.setCapability("appPackage","com.test.vertical");//被测app的包名
        cap.setCapability("appActivity",".home.activity.SplashActivity");//被测app的入口Activity名称
        cap.setCapability("unicodeKeyboard", "True"); //支持中文输入
        cap.setCapability("resetKeyboard", "True"); //支持中文输入，必须两条都配置
        cap.setCapability("noSign", "True"); //不重新签名apk
        cap.setCapability("newCommandTimeout", "30"); //没有新命令，appium30秒退出
        cap.setCapability("noReset", "True"); //没有新命令，appium30秒退出
        cap.setCapability("fullReset", "False"); //没有新命令，appium30秒退出
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);//把以上配置传到appium服务端并连接手机
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//隐式等待
        //driver.tap(1, 100, 600, 1000);

        TouchAction act = new TouchAction(driver);
        act.tap(100,600);


//        long aa = 0;
//        for(int i = 0 ; i < 10 ; i++) {
//
//            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);//把以上配置传到appium服务端并连接手机
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//隐式等待
//            MobileElement ael1 = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"当前所在页面,与测试的聊天\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView");
//            ael1.click();
//            MobileElement ael2 = null;
//            long startTime = 0 ;
//            long endTime = 0;
//            if(flag == 1) {
//                startTime = System.currentTimeMillis();
//                ael2 = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"当前所在页面,与测试的聊天\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/com.tencent.mm.ui.mogic.WxViewPager/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[9]");
//                endTime = System.currentTimeMillis(); //获取结束时间
//                System.out.print("findElementByXPath程序运行时间： " + (endTime - startTime));
//            } else {
//                startTime = System.currentTimeMillis();
//                ael2 = (MobileElement) driver.findElementByAndroidUIAutomator("text(\"小程序\")");
//                endTime = System.currentTimeMillis(); //获取结束时间
//                System.out.print("findElementByAndroidUIAutomator程序运行时间： " + (endTime - startTime));
//            }
//            ael2.click();
//            aa = aa + (endTime - startTime);
//            driver.quit();
//
//        }
//        System.out.println(aa/20);



        return aaa;
    }


}