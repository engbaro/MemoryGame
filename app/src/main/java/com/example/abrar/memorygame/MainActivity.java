package com.example.abrar.memorygame;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class MainActivity extends Activity{


    private ArrayList<Integer> objects = new ArrayList<Integer>();

   int i=0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objects.add(R.drawable.cat);
        objects.add(R.drawable.cat);
        objects.add(R.drawable.lobster);
        objects.add(R.drawable.lobster);
        objects.add(R.drawable.octopus);
        objects.add(R.drawable.octopus);
        objects.add(R.drawable.lion);
        objects.add(R.drawable.lion);
        objects.add(R.drawable.elephent);
        objects.add(R.drawable.elephent);
        Collections.shuffle(objects);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Drawable s = new Drawable() {
                    @Override
                    public void draw(Canvas canvas) {

                    }

                    @Override
                    public void setAlpha(int alpha) {

                    }

                    @Override
                    public void setColorFilter(ColorFilter cf) {

                    }

                    @Override
                    public int getOpacity() {
                        return 0;
                    }
                };

                view.setBackgroundResource(objects.get(i));
                if (view.getBackground()==s)
                    parent.setEnabled(false);
                i++;
                if (i>objects.size()+1){
                    i=0;
                    View m=view;
                     s=m.getBackground();
                }

            }
        });
    }



}
