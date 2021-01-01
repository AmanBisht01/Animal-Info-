package com.aman.animalsinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public  class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.animalRowHolder> {
    ArrayList<Animal> animalData;
    Context context;
    MyClickInterface myclickinterface;
    public AnimalAdapter(ArrayList<Animal> animalData, MainActivity context, MyClickInterface myclickinterface){

        this.context=context;
        this.animalData=animalData;
        this.myclickinterface=myclickinterface;
    }



    @NonNull
    @Override
    public animalRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate( R.layout.animal,parent,false);
//        parent.addView(view);
        return new animalRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull animalRowHolder holder, int position) {
        holder.textView.setText(animalData.get(position).getName());
        holder.imganimal.setImageResource(animalData.get(position).getImage());

    }


    @Override
    public int getItemCount() {
        return animalData.size();
    }

    class animalRowHolder extends RecyclerView.ViewHolder{

          TextView textView;
        ImageView imganimal;
        public animalRowHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.text);
            imganimal =itemView.findViewById(R.id.img_amimal);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myclickinterface.onitemclick(getAdapterPosition());
                }
            });
//            itemView.setOnClickListener(v -> myclickinterface.onitemclick(getAdapterPosition()));

        }
    }
    interface MyClickInterface{
        void onitemclick(int positionofTheAnimal);
    }
}
