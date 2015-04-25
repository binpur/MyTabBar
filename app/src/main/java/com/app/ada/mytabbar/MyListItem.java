package com.app.ada.mytabbar;

/**
 * Created by Administrator on 2015/4/25.
 */
public class MyListItem {

    private String name;
    private int iconResId;

    public MyListItem(String name, int iconResId) {
        this.name = name;
        this.iconResId = iconResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }
}
