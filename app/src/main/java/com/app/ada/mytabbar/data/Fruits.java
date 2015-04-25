package com.app.ada.mytabbar.data;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import com.app.ada.mytabbar.MyListItem;
import com.app.ada.mytabbar.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/25.
 */
public class Fruits {
    private final String TAG = Fruits.class.getCanonicalName();
    private List<MyListItem> ITEMS = new ArrayList<MyListItem>();

    public Fruits(Context context) {

        try {
            AssetManager assetManager = context.getAssets();
            InputStream ims = assetManager.open("fruit.json");
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(ims);


            MyListItem[] gsonArray = gson.fromJson(reader, MyListItem[].class);
            Log.i(TAG, "gsonArray size ="+gsonArray.length);

            for( MyListItem item :gsonArray)
                ITEMS.add(item);

        }catch(IOException e) {
            e.printStackTrace();
        }

    }

    public List<MyListItem> getITEMS() {
        return ITEMS;
    }
}
