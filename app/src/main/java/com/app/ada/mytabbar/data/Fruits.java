package com.app.ada.mytabbar.data;

import com.app.ada.mytabbar.MyListItem;
import com.app.ada.mytabbar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/25.
 */
public class Fruits {
    public static List<MyListItem> ITEMS = new ArrayList<MyListItem>();

    static {
        // Add 3 sample items.
        ITEMS.add(new MyListItem("apple", R.drawable.apple));

    }


}
