package psoft.com.localdatastorage;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import psoft.com.localdatastorage.model.DataItem;
import psoft.com.localdatastorage.sample.SampleDataProvider;
import psoft.com.localdatastorage.utils.DataItemAdapter;

public class MainActivity extends AppCompatActivity {


    List<DataItem> dataItemList = SampleDataProvider.itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Collections.sort(dataItemList, new Comparator<DataItem>() {
            @Override
            public int compare(DataItem o1, DataItem o2) {
                return o1.getItemName().compareTo(o2.getItemName());
            }
        });


        DataItemAdapter adapter = new DataItemAdapter(this,dataItemList);
        ListView listView = (ListView)findViewById(android.R.id.list);
        listView.setAdapter(adapter);

    }
}
