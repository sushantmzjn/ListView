package com.tp4.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView country;


    public static final String countries[]={"Nepal", "Kathmandu", "China", "Beijing", "India", "New Dehli"};

    private Map<String,String> countryy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        country = findViewById(R.id.list);

        countryy = new HashMap<>();
        for (int i = 0; i<countries.length; i=i+2){
            countryy.put(countries[i],countries[i+1]);

        }


        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                new ArrayList<String>(countryy.keySet()));
                country.setAdapter(adapter);

                country.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String C =  parent.getItemAtPosition(position).toString();
                        String CA = countryy.get(C);
                        Toast.makeText(MainActivity.this, "Capital of " +C+ " is : " + CA , Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
