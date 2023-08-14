package com.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Demo {

    public static void main(String[] args) throws Exception {
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

        MobileElement ael1 = null;
        //ael1 = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"当前所在页面,与测试的聊天\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView");
        ael1 = (MobileElement) driver.findElementByAndroidUIAutomator("text(\"发现\")");
        ael1.click();
        MobileElement ael2 = null;
        //ael2 = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"当前所在页面,与测试的聊天\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/com.tencent.mm.ui.mogic.WxViewPager/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[9]");
        ael2 = (MobileElement) driver.findElementByAndroidUIAutomator("text(\"小程序\")");
        ael2.click();
        MobileElement ael3 = (MobileElement) driver.findElementById("com.tencent.mm:id/ccj");
        ael3.click();
        MobileElement ael4 = (MobileElement) driver.findElementById("com.tencent.mm:id/lo");
        ael4.click();
        Thread.sleep(5000);

        //Assert.assertNotNull(new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'分类')]"))));

        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//        WebElement showClose = new AndroidDriverWait(driver, 60)
//                .until(new ExpectedCondition<WebElement>() {
//                    public WebElement apply(AndroidDriver d) {
//                        return d.findElement(By
//                                .id("com.tencent.mm:id/cp"));
//                    }
//
//                });
//        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("com.tencent.mm:id/cp");
//        el4.click();
        //MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.ImageView");

        //System.out.println(driver.getPageSource());
//        MobileElement el4 = (MobileElement) driver.findElementByAndroidUIAutomator("text(\"分类\")");
//        el4.click();
//        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("互联网油烟机free 智享版");
//        el5.click();
//        MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("加入购物车");
//        el6.click();
//        MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("加入购物车");
//        el7.click();
//        MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId("立即购买");
//        el8.click();
//        MobileElement el9 = (MobileElement) driver.findElementByAccessibilityId("立即购买");
//        el9.click();
//        MobileElement el10 = (MobileElement) driver.findElementByAccessibilityId("￥2499");
//        el10.click();
//        MobileElement el11 = (MobileElement) driver.findElementByAccessibilityId("+￥0");
//        el11.click();
//        MobileElement el12 = (MobileElement) driver.findElementByAccessibilityId("无可用");
//        el12.click();

        MobileElement el4 = (MobileElement) driver.findElementByXPath("//*[@*='分类']");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("//*[@*='互联网油烟机free 智享版']");
        el5.click();
        Thread.sleep(5000);
        MobileElement el6 = (MobileElement) driver.findElementByXPath("//*[@*='加入购物车']");
        el6.click();
        Thread.sleep(5000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("//*[@*='加入购物车']");
        el7.click();
        Thread.sleep(5000);
        MobileElement el8 = (MobileElement) driver.findElementByXPath("//*[@*='立即购买']");
        el8.click();
        Thread.sleep(5000);
        MobileElement el9 = (MobileElement) driver.findElementByXPath("//*[@*='加入购物车']");
        el9.click();
        Thread.sleep(5000);
        MobileElement el10 = (MobileElement) driver.findElementByXPath("//*[@*='暂无地址信息哟~请点击创建您的地址']");
        el10.click();
        Thread.sleep(5000);
        MobileElement el11 = (MobileElement) driver.findElementByXPath("//*[@*='请输入收货人姓名']");
        el11.sendKeys("123");
//        MobileElement el12 = (MobileElement) driver.findElementByAccessibilityId("无可用");
//        el12.click();



//        adb shell /system/bin/screencap -p /sdcard/screenshot.png （截图保存到手机sdcard）
//
//        adb pull /sdcard/screenshot.png f:/screenshot.png （上传图片到电脑，路径可以随便改）
//
//        adb shell rm /sdcard/screenshot.png （删除手机sdcard图片）

//        excuteAdbShell("cmd.exe /C adb shell /system/bin/screencap -p /sdcard/screenshot.png");
//        excuteAdbShell("cmd.exe /C adb pull /sdcard/screenshot.png D:/screenshot.png");
//        excuteAdbShell("cmd.exe /C adb shell rm /sdcard/screenshot.png");
//        driver.quit();


    }


    public static void Screenshot(AndroidDriver driver,String path,String name) throws Exception {
        File srcFile = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("d:\\screenshot\\"+"screenshot.png"));
    }


    public static MobileElement findElementByAccessibilityIdWithScreenshot(AndroidDriver driver,String Id) throws Exception {
        Screenshot(driver,"","");
        return (MobileElement) driver.findElementByAccessibilityId("加入购物车");
    }

    public static MobileElement findElementByAndroidUIAutomatorWithScreenshot(AndroidDriver driver,String Id) throws Exception {
        Screenshot(driver,"","");
        return (MobileElement) driver.findElementByAndroidUIAutomator("加入购物车");
    }
    /**
     * 执行adb命令
     * @param s 要执行的命令
     */
    private static void excuteAdbShell(String s) {
        Runtime runtime=Runtime.getRuntime();
        try{
            runtime.exec(s);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void startRecord() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("cmd.exe /C adb shell rm /sdcard/runCase.mp4");
        rt.exec("cmd.exe /C adb shell screenrecord --time-limit 180 /sdcard/runCase.mp4");
    }

    public static void stopRecord() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("cmd.exe /C adb pull /sdcard/runCase.mp4 D:/runCase.mp4");
        rt.exec("cmd.exe /C adb shell rm /sdcard/runCase.mp4");
    }

}