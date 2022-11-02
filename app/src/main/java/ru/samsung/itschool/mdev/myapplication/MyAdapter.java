package ru.samsung.itschool.mdev.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewRow> {


    private ArrayList<MainActivity.Block> arrayList;

    public MyAdapter(ArrayList<MainActivity.Block> arrayList) {
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public ViewRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new ViewRow(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewRow holder, int position) {
        holder.textView.setText(arrayList.get(position).getName());
        // загрузка изображения из Сети
        Picasso.get().load(arrayList.get(position).getUrl()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RRRR","123123");
                Snackbar.make(view.getRootView().findViewById(R.id.root),"Position: "+holder.getAdapterPosition(),Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewRow extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewRow(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);

        }

    }

}
