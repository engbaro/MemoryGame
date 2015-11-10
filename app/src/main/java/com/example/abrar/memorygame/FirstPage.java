package com.example.abrar.memorygame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

/**
 * Created by abrar on 09/11/15.
 */

public class FirstPage  extends Activity{

     ToggleButton easyLevel,hardLevel;
    Button Play;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);
        easyLevel=(ToggleButton)findViewById(R.id.easy);
        hardLevel=(ToggleButton)findViewById(R.id.hard);
        Play=(Button)findViewById(R.id.play);
        intent=new Intent(FirstPage.this,MainActivity.class);
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }
}
