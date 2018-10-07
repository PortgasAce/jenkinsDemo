package com.example.portgas.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import java.lang.reflect.Field;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Field[] field = R.layout.class.getDeclaredFields();

        LayoutInflater inflater = getLayoutInflater();
        for (int i=0;i<field.length;i++){
            try {
                long time = System.currentTimeMillis();
                inflater.inflate(field[i].getInt(null),new LinearLayout(this));
                Log.d("333", "onCreate: "+field[i].getName()+" = "+(System.currentTimeMillis()-time));
            } catch (Exception e) {
                Log.e("333", "onCreate: ",e);
            }
        }




    }

}
