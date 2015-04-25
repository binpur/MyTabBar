package com.app.ada.mytabbar;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/4/25.
 */
public class MyListAdapter extends ArrayAdapter {
    private Context context;
    private boolean useList = true;
    private String packageName;
    private String TAG = MyListAdapter.class.getCanonicalName();

    public MyListAdapter(Context context, List items) {
        //TODO:simple_list_item_1???
        super(context, android.R.layout.simple_list_item_1, items);
        this.context = context;
        this.packageName = context.getPackageName();
    }

    /*
    Holder for the list items
     */
    private class ViewHolder{
        ImageView icon;
        TextView name;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        MyListItem myListItem = (MyListItem)getItem(position);
        View viewToUse = null;
        // This block exists to inflate the settings list item conditionally based on whether
        // we want to support a grid or list view.

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            if(useList){
                viewToUse = inflater.inflate(R.layout.list_item,null);
            }
            else
                viewToUse = inflater.inflate(R.layout.grid_item,null);

            holder = new ViewHolder();
            holder.name = (TextView)viewToUse.findViewById(R.id.name);
            holder.icon = (ImageView)viewToUse.findViewById(R.id.icon);
            viewToUse.setTag(holder);
        }else{
            viewToUse = convertView;
            holder = (ViewHolder) viewToUse.getTag();
        }

        holder.name.setText(myListItem.getName());
        int iconId = context.getResources().getIdentifier(myListItem.getIconResId(),"drawable",packageName);
        holder.icon.setImageResource(iconId);
        return viewToUse;

    }
}
