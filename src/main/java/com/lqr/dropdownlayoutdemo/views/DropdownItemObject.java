package com.lqr.dropdownlayoutdemo.views;

/**
 * Created by Administrator on 2015/5/28.
 */
public class DropdownItemObject {

    public int id;
    public String text;
    public String value;
    public String suffix;

    public DropdownItemObject(String text,int id,  String value) {
        this.text = text;
        this.id = id;
        this.value = value;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
