package psoft.com.localdatastorage;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import psoft.com.localdatastorage.model.DataItem;
import psoft.com.localdatastorage.sample.SampleDataProvider;

public class MainActivity extends AppCompatActivity {

//    private TextView tvOutPut;

    List<DataItem> dataItemList = SampleDataProvider.itemList;
    List<String> nameList = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // tvOutPut =(TextView) findViewById(R.id.outPut);

        // tvOutPut.setText("");

       /* Collections.sort(dataItemList, new Comparator<DataItem>() {
            @Override
            public int compare(DataItem o1, DataItem o2) {
                return o1.getItemName().compareTo(o2.getItemName());
            }
        });*/

        for (DataItem item :
                dataItemList) {
//            String name = item.getItemName();
//            tvOutPut.append(name+"\n");
            nameList.add(item.getItemName());
        }

        Collections.sort(nameList);

        listView = (ListView) findViewById(android.R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nameList
        );
        listView.setAdapter(adapter);
    }
}
