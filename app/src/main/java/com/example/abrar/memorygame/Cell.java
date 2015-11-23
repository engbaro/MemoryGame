package com.example.abrar.memorygame;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by abrar on 26/10/15.
 */
public class Cell extends ImageView {
    private int mResId;




    public Cell(Context context, int resId) {
        super(context);


       // front=(ImageView)findViewById(R.id.front);
        this.mResId = resId;

     //   close();
        //the new way is to use inflater instead of the close


    }

    public void open() {
        setBackgroundResource(this.mResId);


    }

    public void close() {
        //setBackgroundResource(R.drawable.closed_cell);

    }
}
