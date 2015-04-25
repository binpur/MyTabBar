package com.app.ada.mytabbar;

import android.content.res.Resources;

/**
 * Created by Administrator on 2015/4/25.
 */
public class MyListItem {

    private String name;
    private String text;
    private String iconResId;


    public MyListItem(String name, String text, String iconResId) {
        this.name = name;
        this.text = text;
        this.iconResId = iconResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconResId() {
        return iconResId;
    }

    public void setIconResId(String iconResId) {
        this.iconResId = iconResId;
    }
}
