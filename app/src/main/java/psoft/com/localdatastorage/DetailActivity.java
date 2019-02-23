package psoft.com.localdatastorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import psoft.com.localdatastorage.model.DataItem;
import psoft.com.localdatastorage.sample.SampleDataProvider;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String itemId = getIntent().getExtras().getString(DataItemAdapter.DATA_ITEM_ID);

        DataItem item = SampleDataProvider.dataItemMap.get(itemId);
        Toast.makeText(this, "detail Activity: "+item.getDescription(), Toast.LENGTH_SHORT).show();
    }
}
