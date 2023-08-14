package com.test.pages;

import com.test.task.Entry;

public class Setting extends BasePage {
    private String[] attributes;

    private static int _btnClass = 1;
    private static int _btnClassName = 2;
    private static int _btnClassSubName = 3;


    /**
     * @param page 页签
     *             //	 * @param btnClass 分类
     */
    public Setting(int page, String[] atts) {
        super(page);
        this.attributes = atts;
    }


    @Override
    public void renderUIPage() {
        if (attributes[_btnClass].equals("")) {
        } else {
            //Entry.driver.findElement(By.id(Entry.packageName +":id/btnPWD")).click();
            //Entry.driver.findElementByAndroidUIAutomator("text(\"发现\")").click();
            //System.out.println(Entry.driver.getPageSource());
            //Entry.driver.findElementByAndroidUIAutomator("text(\"" + attributes[_btnClass] + "\")").click();
            super.findElement(Entry.driver,attributes[_btnClass]);
            super.findElement(Entry.driver,attributes[_btnClassName]);
            super.findElement(Entry.driver,attributes[_btnClassSubName]);
        }


    }
}
