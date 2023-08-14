package com.test.pages;

import com.test.task.Entry;
import com.test.tools.tool;
import io.appium.java_client.android.AndroidDriver;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WPABasePage {
    public int page;
    //public String bagName;

    public WPABasePage(int page) {
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

        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"搜索\"]").click();
        //tool.sleep(8000);
        //driver.findElementById("com.tencent.mm:id/hz").sendKeys("viomimall");
        driver.findElementByXPath("//*[@*='搜索']").sendKeys("");
//        driver.findElementByAndroidUIAutomator("text(\"发现\")").click();
//        tool.sleep(4000);
//        driver.findElementByAndroidUIAutomator("text(\"搜一搜\")").click();
//        tool.sleep(4000);

//        driver.findElementByAndroidUIAutomator("text(\"公众号\")").click();
//        driver.findElementByXPath("//*[@*='公众号']").click();
//        tool.sleep(4000);
        driver.findElementByAndroidUIAutomator("text(\"商城\")").click();
//        tool.sleep(4000);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tool.sleep(5000);
        if(xpath.indexOf("::") == -1)
            Entry.driver.findElementByXPath("//*[@*='"+xpath+"']").click();
        else
            Entry.driver.findElementByXPath("//*[@*='"+xpath.split("::")[0]+"']").sendKeys(xpath.split("::")[1]);
    }


}
