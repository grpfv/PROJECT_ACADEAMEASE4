package com.example.project_acadeamease1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< Updated upstream

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.Objects;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;

    ArrayList<DataClass> dataList;


    public MyAdapter(ArrayList<DataClass> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    public MyAdapter(FirestoreRecyclerOptions<DataClass> options, Tab_Album context) {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.staggered_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getImageURL()).into(holder.staggeredImages);
    }

    @Override
    public int getItemCount() {

        return dataList.size();
    }

    public void startListening() {

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        RoundedImageView staggeredImages;

        public MyViewHolder(@NonNull View itemView) {
            super(Objects.requireNonNull(itemView));
            staggeredImages = itemView.findViewById(R.id.staggeredImages);
        }
    }

}
=======
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private ArrayList<DataClass> dataList;
    private Context context;
    LayoutInflater layoutInflater;

    public MyAdapter(Context context, ArrayList<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (layoutInflater == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null){
            view = layoutInflater.inflate(R.layout.grid_item, null);
        }

        ImageView gridImage = view.findViewById(R.id.gridImage);
        TextView gridCaption = view.findViewById(R.id.gridCaption);


        Glide.with(context).load(dataList.get(i).getImageURL()).into(gridImage);
        gridCaption.setText(dataList.get(i).getCaption());

        return view;
    }
}
>>>>>>> Stashed changes
