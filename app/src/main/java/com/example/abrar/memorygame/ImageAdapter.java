package com.example.abrar.memorygame;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.Inflater;

/**
 * Created by abrar on 26/10/15.
 */


public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    final Handler handler = new Handler();
    private ArrayList<View> openedCells = new ArrayList<View>();
    private ArrayList<View> diselem = new ArrayList<>();
    private ArrayList<Integer> objects = new ArrayList<Integer>();
    int count = 0;


    public ImageAdapter(Context c) {
        mContext = c;
        for (int i : mThumbIds) {
            objects.add(i);
            objects.add(i);
        }
        Collections.shuffle(objects);
    }

    public int getCount() {
        return this.objects.size();
    }

    public Object getItem(int position) {
        return position;
    }


    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {


        // front=(ImageView)view.findViewById(R.id.imgFront);
        //  final ViewHolder viewHolder=new ViewHolder();
        View view = new View(mContext);
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.frontback, null);

            convertView = view;

            //   cell.setLayoutParams(new GridView.LayoutParams(200, 200));
            //     cell.setScaleType(ImageView.ScaleType.FIT_XY);
            // cell.setPadding(8, 8, 8, 8);
        } else {
            view = convertView;
            //  cell = (Cell) convertView;
        }
        final ViewFlipper flipper;
        ImageView back;
        final ImageView front;
        flipper = (ViewFlipper) view.findViewById(R.id.elem);
        flipper.setInAnimation(mContext, R.anim.scale_in);
        flipper.setOutAnimation(mContext, R.anim.scale_out);
        flipper.setDisplayedChild(0);
        back = (ImageView) view.findViewById(R.id.imgBack);
        front = (ImageView) view.findViewById(R.id.imgFront);
        front.setBackgroundResource(objects.get(position));

        // ImageView m=front;
        // final ViewFlipper v=flipper;
        flipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setRightOut.setTarget(imgFront);
                //setLeftIn.setTarget(imgBack);
                // setRightOut.start();
                // setLeftIn.start();


                if (openedCells.size() < 2) {
                    flipper.showNext();
                    openedCells.add(flipper);
                }
                if (openedCells.size() == 2) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            // Do something after 5s = 5000ms
                            closeOpenedCells(openedCells);
                            checkwin();
                            openedCells.clear();
                        }
                    }, 1000);
                }

            }
        });


        //return cell;
        return view;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.cat, R.drawable.elephant,
            R.drawable.bird, R.drawable.lion,
            R.drawable.dog2, R.drawable.rat,

    };

    void closeOpenedCells(ArrayList<View> m) {
        ViewFlipper cell0, cell1;

        cell0 = (ViewFlipper) m.get(0);
        cell1 = (ViewFlipper) m.get(1);

        if (cell0.getChildAt(1).getBackground().getConstantState() == cell1.getChildAt(1).getBackground().getConstantState()) {
            cell0.setEnabled(false);
            cell1.setEnabled(false);
            diselem.add(cell0);
            diselem.add(cell1);
            count += 2;
        } else {
            cell0.showNext();
            cell1.showNext();
        }
        // I placed it here the first time buti cause error
        //  m.clear();
    }

    void checkwin() {
        if (count == objects.size()) {
            Toast.makeText(mContext, "you won",
                    Toast.LENGTH_LONG).show();
        }


    }


}


