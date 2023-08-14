package com.test.pages;

import com.test.task.Entry;
import com.test.tools.tool;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WMPBasePage {
    public int page;
    //public String bagName;

    public WMPBasePage(int page) {
        super();
        this.page = page;
    }

    public void updateUIPage() {
    }

    public String getNodeByText(AndroidDriver driver, String xpath) {
        if (xpath.indexOf("::") > -1) {
            xpath = xpath.split("::")[0];
        }
        String node = "";
        xpath = "//*[@*='" + xpath + "']";
        try {
            tool.sleep(2000);
            Document document = DocumentHelper.parseText(driver.getPageSource());
            List<Element> composites = document.selectNodes(xpath);
            if (composites != null) {
                for (Element e : composites) {
                    //System.out.println(e.getName()+"="+e.getStringValue());
                    node = e.getName();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return node;
    }

    public void findElement(AndroidDriver driver, String xpath) {

        //小程序init开始
        driver.findElementByAndroidUIAutomator("text(\"发现\")").click();
        tool.sleep(4000);
        driver.findElementByAndroidUIAutomator("text(\"小程序\")").click();
        tool.sleep(4000);
        //weixin6.0
        MobileElement el3 = (MobileElement) driver.findElementById("com.tencent.mm:id/be");
        //weixin7.0
        //MobileElement el3 = (MobileElement) driver.findElementById("com.tencent.mm:id/iq");
        el3.click();
        //driver.findElementById("com.tencent.mm:id/ccj").click();
        //tool.sleep(2000);
        //driver.findElementById("com.tencent.mm:id/lo").click();
        //Thread.sleep(5000);
        //小程序init结束

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tool.sleep(5000);
        if(xpath.indexOf("::") == -1)
            Entry.driver.findElementByXPath("//*[@*='"+xpath+"']").click();
        else
            Entry.driver.findElementByXPath("//*[@*='"+xpath.split("::")[0]+"']").sendKeys(xpath.split("::")[1]);
    }


}
