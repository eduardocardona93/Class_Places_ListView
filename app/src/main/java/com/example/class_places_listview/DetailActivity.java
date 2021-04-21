package com.example.class_places_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    ArrayList<String> imagesList ;

    TextView poiNameLbl, poiDescription;
    ImageView placeImgBig;
    ListView placeImgLv;
    Button returnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        poiNameLbl = findViewById(R.id.poiNameLbl);
        poiDescription = findViewById(R.id.poiDescription);
        placeImgBig = findViewById(R.id.placeImgBig);
        placeImgLv = findViewById(R.id.placeImgLv);
        returnButton = findViewById(R.id.returnButton);

        imagesList = MainActivity.selectedPlace.getImages();
        poiNameLbl.setText(MainActivity.selectedPlace.getName());
        poiDescription.setText(MainActivity.selectedPlace.getDescription());

        placeImgLv.setAdapter(new PlaceImageAdapter(getBaseContext(),imagesList));
        placeImgBig.setImageResource(getResources().getIdentifier(MainActivity.selectedPlace.getImages().get(0),"mipmap",getPackageName()));
        placeImgLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int imgId=getResources().getIdentifier(MainActivity.selectedPlace.getImages().get(position),"mipmap",getPackageName());
                placeImgBig.setImageResource(imgId);
            }
        });


        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}