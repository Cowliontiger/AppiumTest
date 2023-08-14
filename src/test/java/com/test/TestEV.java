package com.test;

import com.test.tools.tool;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestEVK {

    public static void main(String[] args) throws Exception {
        for(int i = 0 ; i < 1 ; i++)
            test(1);
    }

    public static long test(int flag)  throws Exception {
        long aaa = 0;

        AndroidDriver driver;
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "Appium");//appium做自动化
//    cap.setCapability("app", "C:\\software\\jrtt.apk");//安装apk
//    cap.setCapability("browserName", "chrome");//设置HTML5的自动化，打开谷歌浏览器
        cap.setCapability("deviceName", "ae7a6f47");//设备名称
        cap.setCapability("platformName", "Android"); //安卓自动化还是IOS自动化
        cap.setCapability("platformVersion", "8.0.0"); //安卓操作系统版本
//        cap.setCapability("platformVersion", "4.4.2"); //安卓操作系统版本
//        cap.setCapability("udid", "192.168.56.101:5555"); //设备的udid (adb devices 查看到的)
        cap.setCapability("appPackage", "com.test.ek");//被测app的包名
        cap.setCapability("appActivity", "com.test.ek.MainActivity");//被测app的入口Activity名称
        cap.setCapability("unicodeKeyboard", "True"); //支持中文输入
        cap.setCapability("resetKeyboard", "True"); //支持中文输入，必须两条都配置
        cap.setCapability("noSign", "True"); //不重新签名apk
//        cap.setCapability("newCommandTimeout", "30"); //没有新命令，appium30秒退出
//        cap.setCapability("noReset", "True"); //没有新命令，appium30秒退出t
//        cap.setCapability("fullReset", "False"); //没有新命令，appium30秒退出

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);//把以上配置传到appium服务端并连接手机
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//隐式等待

        driver.findElementById("android:id/button1").click();

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[2]").click();

        tool.swipeTo(driver,500,1400,500,900,1000);

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[1]").click();

        driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Forward Button\"]").click();

        driver.findElementByXPath("\t\n" +
                "\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[4]/android.view.View[1]").click();

        driver.findElementByXPath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[1]/android.view.View[4]").click();

        driver.findElementById("android:id/button1").click();

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/" +
                "android.widget.LinearLayout[2]/android.widget.ImageView").click();

        driver.findElementById("com.tencent.mobileqq:id/iji").click();
        tool.sleep(2000);
        driver.findElementById("com.tencent.mobileqq:id/et_search_keyword").sendKeys("harry");

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.AbsListView/android.widget.RelativeLayout[1]/android.widget.ImageView").click();

        driver.findElementById("com.tencent.mobileqq:id/dialogRightBtn").click();

        driver.findElementById("com.tencent.mobileqq:id/dialogLeftBtn").click();

        driver.quit();

        return aaa;
    }



}