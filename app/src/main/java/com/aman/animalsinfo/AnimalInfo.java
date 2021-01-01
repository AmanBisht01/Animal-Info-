package com.aman.animalsinfo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AnimalInfo extends AppCompatActivity {
    ImageView img;
    TextView txt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animalinfo);

        img=findViewById(R.id.imgcircle);
        txt=findViewById(R.id.animal);

        Intent intent=getIntent();
        img.setImageResource(intent.getIntExtra("image", R.drawable.dolphi));
        txt.setText(intent.getStringExtra("name"));
    }
}
