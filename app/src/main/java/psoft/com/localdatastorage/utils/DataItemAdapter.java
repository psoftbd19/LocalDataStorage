package psoft.com.localdatastorage.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import psoft.com.localdatastorage.R;
import psoft.com.localdatastorage.model.DataItem;

public class DataItemAdapter extends ArrayAdapter<DataItem> {

    List<DataItem> mItemList;
    LayoutInflater mInflater;

    public DataItemAdapter(@NonNull Context context, @NonNull List<DataItem> objects) {
        super(context, R.layout.list_item, objects);
        mItemList =objects;
        mInflater = LayoutInflater.from(context);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item,parent,false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        TextView tvItemName = (TextView) convertView.findViewById(R.id.tvItemName);

        DataItem dataItem = mItemList.get(position);

        tvItemName.setText(dataItem.getItemName());
        imageView.setImageResource(R.drawable.apple_pie);



        return convertView;
    }
}
