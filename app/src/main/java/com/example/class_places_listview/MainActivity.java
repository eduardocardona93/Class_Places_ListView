package com.example.class_places_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String countries[] = {"Canada","India", "Jordan", "Colombia", "Dominican Republic"};
    ArrayList<Place> allPlaces = new ArrayList<>();
    ArrayList<Place> countryPlaces = new ArrayList<>();
    ArrayList<String> images = new ArrayList<>();

    ListView placesLV;
    Spinner countrySp;

    public static Place selectedPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillData();
        countrySp = findViewById(R.id.countrySp);
        placesLV = findViewById(R.id.placesLV);
        ArrayAdapter ad = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, countries);
        countrySp.setAdapter(ad);

        countrySp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                countryPlaces.clear();
                for (Place pl: allPlaces) {
                    if (pl.getCountry().equals(countries[position])){
                        countryPlaces.add(pl);
                    }
                }
                placesLV.setAdapter(new PlaceAdapter(getBaseContext(), countryPlaces));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                countryPlaces.clear();
                for (Place pl: allPlaces) {
                    if (pl.getCountry().equals(countries[0])){
                        countryPlaces.add(pl);
                    }
                }
                placesLV.setAdapter(new PlaceAdapter(getBaseContext(), countryPlaces));
            }


        });
        placesLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPlace = countryPlaces.get(position);
                Intent intent = new Intent(getBaseContext(), DetailActivity.class);
                startActivity(intent);
            }
        });


    }

    public void fillData(){

        allPlaces.add(new Place("Niagara Falls",countries[0],"Niagara Falls, Ontario, is a Canadian city at the famous waterfalls of the same name, linked with the U.S. by the Rainbow Bridge. Its site on the Niagara River's western shore overlooks the Horseshoe Falls, the cascades' most expansive section. Elevators take visitors to a lower, wetter vantage point behind the falls. A cliffside park features a promenade alongside 520-ft.-high Skylon Tower with an observation deck",returnImages(3, "niagara") ));

        allPlaces.add(new Place("Thousand Islands",countries[0],"The Thousand Islands are a group of more than 1,800 islands in the St. Lawrence River, straddling the border of the U.S. and Canada. A fashionable retreat for the elite in the late 19th century, today the area is a hub for outdoor activities",returnImages(3, "thousand")));

        allPlaces.add(new Place("Banff National Park",countries[0],"Banff National Park is famous for its surreally coloured lakes, majestic mountains and endless outdoor adventures. Canada's first national park and the world's third, it has a rich heritage as one of the world's most awe-inspiring mountain destinations.",returnImages(3, "bnaff")));

        allPlaces.add(new Place("Taj Mahal",countries[1],"An immense mausoleum of white marble, built in Agra between 1631 and 1648 by order of the Mughal emperor Shah Jahan in memory of his favourite wife, the Taj Mahal is the jewel of Muslim art in India and one of the universally admired masterpieces of the world's heritage",returnImages(3, "taj")));

        allPlaces.add(new Place("Mehrangarh Fort",countries[1],"Mehrangarh, located in Jodhpur, Rajasthan, is one of the largest forts in India. Built around 1459 by Rao Jodha, the fort is situated 410 feet above the city and is enclosed by imposing thick walls. Inside its boundaries there are several palaces known for their intricate carvings and expansive courtyards",returnImages(3, "fort")));

        allPlaces.add(new Place("Golden Temple",countries[1],"Harmandir Sahib, Harmandir also spelled Harimandir, also called Darbar Sahib (Punjabi: “Sacred Audience”) or Golden Temple, the chief gurdwara, or house of worship, of Sikhism and the Sikhs' most important pilgrimage site. It is located in the city of Amritsar, Punjab state, northwestern India.",returnImages(3, "golden")));

        allPlaces.add(new Place("Guatape",countries[2],"Guatapé is an Andean resort town in northwest Colombia, east of Medellín. It’s known for its houses decorated with colorful bas-reliefs. It sits by the vast, man-made Peñol-Guatapé Reservoir, a busy water-sports center. Piedra del Peñol, a giant granite rock southwest of town, has hundreds of steps to the top",returnImages(3, "guatape") ));

        allPlaces.add(new Place("Seven Colors River",countries[2],"Caño Cristales is a Colombian river located in the Serrania de la Macarena province of Meta, and is a tributary of the Guayabero River. The river is commonly called the \"River of Five Colors\" or the \"Liquid Rainbow,\" and is noted for its striking colors.",returnImages(3, "river")));


        allPlaces.add(new Place("Las Dunas De Bani",countries[3],"Dunas de Bani is a small island with 15 kilometers of just pure sand stretching from the town of Matanzas to Las Salinas at Puerto Hermoso, Santo Domingo.\n" +
                "\n" +                 "Amid the brown sand dunes, you will find native flora like cacti, olive trees, and other plants. To inquire about filming at this location, visit LocationsHub.com.",returnImages(3, "dunas") ));


        allPlaces.add(new Place("Los Haitises",countries[3],"Los Haitises National Park is a national park located on the remote northeast coast of the Dominican Republic that was established in 1976. It consists of a limestone karst plateau with conical hills, sinkholes and caverns, and there is a large area of mangrove forest on the coast. Wikipedia",returnImages(3, "los")));

        allPlaces.add(new Place("Petra",countries[4],"Petra is a famous archaeological site in Jordan's southwestern desert. Dating to around 300 B.C., it was the capital of the Nabatean Kingdom. Accessed via a narrow canyon called Al Siq, it contains tombs and temples carved into pink sandstone cliffs, earning its nickname, the \"Rose City",returnImages(3, "petra")));


        allPlaces.add(new Place("Wadi Rum",countries[4],"Wadi Rum is a protected desert wilderness in southern Jordan. It features dramatic sandstone mountains like the many-domed Jebel Um Ishrin, and natural arches such as Burdah Rock Bridge. Many prehistoric inscriptions and carvings line rocky caverns and steep chasms",returnImages(3, "rum")));


        allPlaces.add(new Place("Ma'in Hot Springs",countries[4],"The Ma'in Hot Springs also known as Hammamat Ma'in are a series of hot mineral springs and waterfalls located between Madaba and the Dead Sea in Madaba Governorate, Jordan.",returnImages(3, "main")));


        allPlaces.add(new Place("Dead Sea",countries[4],"The Dead Sea is a salt lake bordered by Jordan to the east and Israel and the West Bank to the west. It lies in the Jordan Rift Valley, and its main tributary is the Jordan River. The lake's surface is 430.5 metres below sea level, making its shores the lowest land-based elevation on Earth",returnImages(3, "sea")));
    }


    public ArrayList<String> returnImages(int n, String name){
        ArrayList<String> imagesNames = new ArrayList<>();
        for (int i=0 ; i < n; i++){
            imagesNames.add(name + i);
        }
        return imagesNames;
    }

}