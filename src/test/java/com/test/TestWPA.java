package com.test;

import com.test.tools.tool;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestWPA {

    public static void main(String[] args) throws Exception {
        for(int i = 0 ; i < 20 ; i++)
            test(1);
    }

    public static long test(int flag)  throws Exception {
        long aaa = 0;

        AndroidDriver driver;
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "Appium");//appium做自动化
//    cap.setCapability("app", "C:\\software\\jrtt.apk");//安装apk
//    cap.setCapability("browserName", "chrome");//设置HTML5的自动化，打开谷歌浏览器
        cap.setCapability("deviceName", "127.0.0.1:7555");//设备名称
        cap.setCapability("platformName", "Android"); //安卓自动化还是IOS自动化
        cap.setCapability("platformVersion", "6.0.1"); //安卓操作系统版本
//        cap.setCapability("platformVersion", "4.4.2"); //安卓操作系统版本
//        cap.setCapability("udid", "192.168.56.101:5555"); //设备的udid (adb devices 查看到的)
        cap.setCapability("appPackage", "com.tencent.mm");//被测app的包名
        cap.setCapability("appActivity", ".ui.LauncherUI");//被测app的入口Activity名称
        cap.setCapability("unicodeKeyboard", "True"); //支持中文输入
        cap.setCapability("resetKeyboard", "True"); //支持中文输入，必须两条都配置
        cap.setCapability("noSign", "True"); //不重新签名apk
        cap.setCapability("newCommandTimeout", "30"); //没有新命令，appium30秒退出
        cap.setCapability("noReset", "True"); //没有新命令，appium30秒退出
        cap.setCapability("fullReset", "False"); //没有新命令，appium30秒退出
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);//把以上配置传到appium服务端并连接手机
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//隐式等待
        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"搜索\"]").click();
        //tool.sleep(8000);
        driver.findElementByXPath("//*[@*='搜索']").sendKeys("");
//        driver.findElementByAndroidUIAutomator("text(\"发现\")").click();
//        tool.sleep(4000);
//        driver.findElementByAndroidUIAutomator("text(\"搜一搜\")").click();
//        tool.sleep(4000);

//        driver.findElementByAndroidUIAutomator("text(\"公众号\")").click();
//        driver.findElementByXPath("//*[@*='公众号']").click();
//        tool.sleep(4000);
        driver.findElementByAndroidUIAutomator("text(\"商城\")").click();
        tool.sleep(4000);
//        List<WebElement> elements = driver.findElementsByAndroidUIAutomator("resourceId(\"com.tencent.mm:id/ln\")");
//        elements.get(1).click();
        //driver.findElementByAndroidUIAutomator("resourceId(\"com.tencent.mm:id/ln\")").click();
        //第一次才要求定位
        //driver.findElementById("com.tencent.mm:id/an3").click();
        driver.findElementByXPath("//*[@*='商城']").click();
        driver.findElementByXPath("//*[@*='智能']").click();
        driver.findElementByXPath("//*[@*='小家电']").click();
        driver.findElementByXPath("//*[@*='IH电']").click();
        driver.findElementByXPath("//*[@*='加入购物车']").click();
        driver.findElementByXPath("//*[@*='确定']").click();
        driver.findElementByXPath("//*[@*='立即购买']").click();
        driver.findElementByXPath("//*[@*='确定']").click();
        driver.findElementByXPath("//*[@*='立即支付']").click();
        //Thread.sleep(10000);
        driver.quit();

        return aaa;
    }


}