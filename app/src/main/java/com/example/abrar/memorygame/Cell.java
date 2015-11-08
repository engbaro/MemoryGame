package com.example.abrar.memorygame;

import android.content.Context;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by abrar on 26/10/15.
 */
public class Cell extends ImageView {
    private int mResId;

    public Cell(Context context, int resId) {
        super(context);
        this.mResId = resId;
        close();

    }

    public void open() {
        setBackgroundResource(this.mResId);
    }

    public void close() {
        setBackgroundResource(R.drawable.closed_cell);
    }
}
