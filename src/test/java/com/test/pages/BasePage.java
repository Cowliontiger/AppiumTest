package com.test.pages;

import com.test.task.Entry;
import com.test.tools.tool;
import io.appium.java_client.android.AndroidDriver;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class BasePage {
    public int page;
    //public String bagName;

    public BasePage(int page) {
        super();
        this.page = page;
    }

    public void renderUIPage() {
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //tool.sleep(5000);
        String type = xpath.split("~~")[1];
        String value = xpath.split("~~")[0];
        if(type.equalsIgnoreCase("id")) {
            Entry.driver.findElementById(value).click();
        } else if(type.equalsIgnoreCase("xpath")) {
            Entry.driver.findElementByXPath(value).click();
        } else if(type.equalsIgnoreCase("customize")) {
            if(tool.findCount(value,",") == 4) {
                String aa[] = value.split(",");
                //todo
                tool.swipeTo(driver,Integer.valueOf(aa[0]),Integer.valueOf(aa[1]),Integer.valueOf(aa[2]),Integer.valueOf(aa[3]),Integer.valueOf(aa[4]));
            }
        } else if(type.equalsIgnoreCase("id&type")) {
            Entry.driver.findElementById(value.split("&")[0]).sendKeys(value.split("&")[1]);
        }
    }


}
