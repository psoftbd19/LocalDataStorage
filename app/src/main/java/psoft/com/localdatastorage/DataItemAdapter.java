package psoft.com.localdatastorage;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import psoft.com.localdatastorage.model.DataItem;

public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.ViewHolder> {


    public static final String ITEM_ID = "item_id";
    public static final String ITEM_KEY ="item_key" ;
    private Context context;
    private List<DataItem> dataItemList;


    public DataItemAdapter(Context context, List<DataItem> dataItemList) {
        this.context = context;
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final DataItem item =dataItemList.get(position);

        holder.tvName.setText(item.getItemName());
        String imageFile=item.getImage();

        try {
            InputStream inputStream = context.getAssets().open(imageFile);
            Drawable drawable = Drawable.createFromStream(inputStream,null);
            holder.itemImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra(ITEM_KEY,item);
                context.startActivity(intent);


            }
        });




    }

    @Override
    public int getItemCount() {
        return dataItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public ImageView itemImage;
        public View view;


        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvItemName);
            itemImage = (ImageView) itemView.findViewById(R.id.imageView);
            view=itemView;
        }
    }

}