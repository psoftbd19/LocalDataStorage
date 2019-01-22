package psoft.com.localdatastorage;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import psoft.com.localdatastorage.model.DataItem;

public class MainActivity extends AppCompatActivity {

    private TextView tvOutPut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOutPut =(TextView) findViewById(R.id.outPut);

        DataItem item = new DataItem("","Shirt","Yellow","L",77,781.67,"shirt.jpg");

        tvOutPut.setText(item.toString());

    }
}
