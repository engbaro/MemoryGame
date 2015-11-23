package com.example.abrar.memorygame;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by abrar on 26/10/15.
 */


public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    final Handler handler = new Handler();
    private ArrayList<Cell> openedCells = new ArrayList<Cell>();
    private ArrayList<Cell> diselem = new ArrayList<>();
    private ArrayList<Integer> objects = new ArrayList<Integer>();
    int count = 0;

    public ImageAdapter(Context c) {
        mContext = c;

        final AnimatorSet setRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(c,
                R.animator.right_out);

        final AnimatorSet setLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(c,
                R.animator.left_in);
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
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        final Cell cell;

        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            cell = new Cell(mContext, objects.get(position));
            cell.setLayoutParams(new GridView.LayoutParams(200, 200));
            cell.setScaleType(ImageView.ScaleType.FIT_XY);
            // cell.setPadding(8, 8, 8, 8);
        } else {
            cell = (Cell) convertView;
        }


        cell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setRightOut.setTarget(imgFront);
                //setLeftIn.setTarget(imgBack);
                // setRightOut.start();
                // setLeftIn.start();


                if (openedCells.size() < 2)
                    cell.open();
                openedCells.add(cell);
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


        return cell;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.bear, R.drawable.cat,
            R.drawable.elephent, R.drawable.lion,
            R.drawable.lobster, R.drawable.octopus,

    };

    void closeOpenedCells(ArrayList<Cell> m) {
        Cell cell0, cell1;

        cell0 = m.get(0);
        cell1 = m.get(1);

        if (cell0.getBackground().getConstantState() == cell1.getBackground().getConstantState()) {
            cell0.setEnabled(false);
            cell1.setEnabled(false);
            diselem.add(cell0);
            diselem.add(cell1);
            count += 2;
        } else {
            cell0.close();
            cell1.close();
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


