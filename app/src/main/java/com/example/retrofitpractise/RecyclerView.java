package com.example.retrofitpractise;

import androidx.appcompat.app.AppCompatActivity;

import android.media.session.PlaybackState;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class RecyclerView extends AppCompatActivity {
    ListView listView;
    String [] CountryName;
    //private String [] CapitalName = {"AFGHANISTAN", "AFGHANISTAN","AFGHANISTAN","AFGHANISTAN","AFGHANISTAN", "AFGHANISTAN","AFGHANISTAN","AFGHANISTAN","AFGHANISTAN", "AFGHANISTAN","AFGHANISTAN","AFGHANISTAN"};
    //private String [] CountryName = {"AFGHANISTAN", "AFGHANISTAN","AFGHANISTAN","AFGHANISTAN","AFGHANISTAN", "AFGHANISTAN","AFGHANISTAN","AFGHANISTAN","AFGHANISTAN", "AFGHANISTAN","AFGHANISTAN","AFGHANISTAN"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        listView = findViewById(R.id.lv);
        CountryName = getResources().getStringArray(R.array.countryName);
        String[] CapitalName = getResources().getStringArray(R.array.capital);
        ArrayAdapter<String> adapter1 =     new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, CapitalName);
        CustomAdapter adapter = new CustomAdapter(this, CountryName, CapitalName);
        Toast.makeText(this, "size is "+CountryName.length, Toast.LENGTH_SHORT).show();
        listView.setAdapter(adapter);
    }
}
