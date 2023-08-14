package com.test.task;


import com.test.task.TestObject;
import com.test.task.TestObjectResultData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.*;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import junit.extensions.RepeatedTest;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.test.tools.CreatAndReadExcel;
import com.test.tools.tool;
import org.springframework.test.annotation.Repeat;

@RunWith(Parameterized.class)
public class Entry {

    public static AndroidDriver driver;
    private static String Path;
    private List<Object> data;
    public static String dataTime = "";
    public static List<TestObjectResultData> res = new ArrayList<TestObjectResultData>();


    //	private static String excelName = "安卓测试模板.xlsx";
    public static String excelName = "EvkAPP.xlsx";

    public static String packageName = "com.tencent.mm";

    public Entry(List<Object> result) {
        super();
        this.data = result;
    }

    @BeforeClass
    public static void BeforeClass() {

        dataTime = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
    }

    @Before
    public void testBefore() throws Exception {
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("automationName", "Appium");//appium做自动化
////    cap.setCapability("app", "C:\\software\\jrtt.apk");//安装apk
////    cap.setCapability("browserName", "chrome");//设置HTML5的自动化，打开谷歌浏览器
//        cap.setCapability("deviceName", "127.0.0.1:7555");//设备名称
//        cap.setCapability("platformName", "Android"); //安卓自动化还是IOS自动化
//        cap.setCapability("platformVersion", "6.0.1"); //安卓操作系统版本
////        cap.setCapability("platformVersion", "4.4.2"); //安卓操作系统版本
////        cap.setCapability("udid", "192.168.56.101:5555"); //设备的udid (adb devices 查看到的)
//        cap.setCapability("appPackage", "com.tencent.mm");//被测app的包名
//        cap.setCapability("appActivity", ".ui.LauncherUI");//被测app的入口Activity名称
//        cap.setCapability("unicodeKeyboard", "True"); //支持中文输入
//        cap.setCapability("resetKeyboard", "True"); //支持中文输入，必须两条都配置
//        cap.setCapability("noSign", "True"); //不重新签名apk
//        cap.setCapability("newCommandTimeout", "30"); //没有新命令，appium30秒退出
//        cap.setCapability("noReset", "True"); //没有新命令，appium30秒退出
//        cap.setCapability("fullReset", "False"); //没有新命令，appium30秒退出
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);//把以上配置传到appium服务端并连接手机

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "Appium");//appium做自动化
        cap.setCapability("deviceName", "ae7a6f47");//设备名称
        cap.setCapability("platformName", "Android"); //安卓自动化还是IOS自动化
        cap.setCapability("platformVersion", "8.0.0"); //安卓操作系统版本
        cap.setCapability("appPackage", "com.xf.evk");//被测app的包名
        cap.setCapability("appActivity", "com.xf.evk.MainActivity");//被测app的入口Activity名称
        cap.setCapability("unicodeKeyboard", "True"); //支持中文输入
        cap.setCapability("resetKeyboard", "True"); //支持中文输入，必须两条都配置
        cap.setCapability("noSign", "True"); //不重新签名apk
//        cap.setCapability("newCommandTimeout", "30"); //没有新命令，appium30秒退出
//        cap.setCapability("noReset", "True"); //没有新命令，appium30秒退出t
//        cap.setCapability("fullReset", "False"); //没有新命令，appium30秒退出
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);//把以上配置传到appium服务端并连接手机
        tool.waitA(driver, 30);

    }

    @After
    public void testAfter() throws InterruptedException {
        driver.quit();
        System.out.println("执行完毕");
        Thread.sleep(1000);
    }

    @AfterClass
    public static void afterClass() {
        try {
            CreatAndReadExcel.write2007Excel(Path, res);
            System.out.println("已写入excel！");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("写入excel失败！");
        }
    }

    @Parameters
    public static Collection data() throws Exception {
        Path = System.getProperty("user.dir") + System.getProperty("file.separator") + excelName;
        List<List<Object>> data1 = CreatAndReadExcel.readExcel(new File(Path));
        return data1;
    }

    @Test
    public void Test() {
        TestObject testObject = new TestObject(data);
        res.add(testObject.runTest());
    }
}
