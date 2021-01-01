package com.aman.animalsinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.MyClickInterface {

    RecyclerView recyclerView;
    ArrayList<Animal> animals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        animals = new ArrayList<>();

        animals.add(new Animal("owl",R.drawable.owl));
        animals.add(new Animal("bird",R.drawable.bird));
        animals.add(new Animal("cat",R.drawable.cat));
        animals.add(new Animal("ara",R.drawable.ara));
        animals.add(new Animal("fish",R.drawable.dolphi));
        animals.add(new Animal("owl",R.drawable.owl));
        animals.add(new Animal("bird",R.drawable.bird));
        animals.add(new Animal("cat",R.drawable.cat));
        animals.add(new Animal("ara",R.drawable.ara));
        animals.add(new Animal("fish",R.drawable.dolphi));

//        AnimalAdapter animalAdapter = new AnimalAdapter(animals, this);
        AnimalAdapter animalAdapter =new AnimalAdapter(animals, this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(animalAdapter);

    }


    @Override
    public void onitemclick(int positionofTheAnimal) {
        Toast.makeText(this, "Clicked " +animals.get(positionofTheAnimal).getName(), Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(this,AnimalInfo.class);
        intent.putExtra("image",animals.get(positionofTheAnimal).getImage() );
        intent.putExtra("name", animals.get(positionofTheAnimal).getName());
        startActivity(intent);
    }
}