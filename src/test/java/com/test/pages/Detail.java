package com.test.pages;

import com.test.task.Entry;
import com.test.tools.tool;

public class Detail extends BasePage {
    private String[] attributes;

//    private static int _btnClass = 0;
//    private static int _btnClassName = 1;
//    private static int _btnClassSubName = 2;
//    private static int _btnClassSubName2 = 3;

    /**
     * @param page 页签
     *             //	 * @param btnClass 分类
     */
    public Detail(int page, String[] atts) {
        super(page);
        this.attributes = atts;
    }


    @Override
    public void renderUIPage() {

        //Entry.driver.findElement(By.id(Entry.packageName +":id/btnPWD")).click();
        //Entry.driver.findElementByAndroidUIAutomator("text(\"发现\")").click();
        //System.out.println(Entry.driver.getPageSource());
        //Entry.driver.findElementByAndroidUIAutomator("text(\"" + attributes[_btnClass] + "\")").click();

//            super.findElement(Entry.driver,attributes[_btnClass]);
//            super.findElement(Entry.driver,attributes[_btnClassName]);
//            super.findElement(Entry.driver,attributes[_btnClassSubName]);
//            super.findElement(Entry.driver,attributes[_btnClassSubName2]);

        for(int i = 0 ; i < attributes.length ; i++){
            if (!attributes[i].equals("")) {
                super.findElement(Entry.driver, attributes[i]);
            } else {
                break;
            }
        }




    }
}
