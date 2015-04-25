package com.app.ada.mytabbar;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/4/25.
 */
public class CustomDialog extends Dialog {
    private Context context;
    private MyListItem item;
    private TextView tvTitle,tvDescription;
    private Button buttonClose;


    public CustomDialog(Context context, MyListItem item) {
        super(context);
        this.context = context;
        this.item = item;
        /*
        Set style of the dialog
         */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCanceledOnTouchOutside(false);
        //getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        /*
        UI elements of the dialog
         */
        setContentView(R.layout.custom_diaglog);
        tvTitle = (TextView)findViewById(R.id.title);
        tvDescription = (TextView)findViewById(R.id.description);
        buttonClose = (Button)findViewById(R.id.button_close);

        /*
        Functionality
         */
        setContent();
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void setContent(){
        tvTitle.setText(item.getName());
        tvDescription.setText(item.getDescription());
    }



}
