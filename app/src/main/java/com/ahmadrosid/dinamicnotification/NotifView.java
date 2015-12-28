package com.ahmadrosid.dinamicnotification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by ocittwo on 12/28/15.
 */
public class NotifView extends RelativeLayout {

    private TextView textView;
    private int count = 0;

    public void setCount(int count) {
        this.count = count;
        if (count < 1){
            textView.setVisibility(View.GONE);
        }else{
            textView.setVisibility(View.VISIBLE);
            textView.setText(String.valueOf(count));
        }
    }

    public NotifView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater mIflate = LayoutInflater.from(context);
        mIflate.inflate(R.layout.notif_view, this);
        textView = (TextView) findViewById(R.id.tvCount);
    }

}
