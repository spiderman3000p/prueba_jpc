package com.developments.vunterslaush.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Comparator;

public class Main2Activity extends AppCompatActivity {
    ArrayList<String> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        // Get the reference of movies
        ListView list=(ListView)findViewById(R.id.listview);
        final EditText numberUser = (EditText) findViewById(R.id.numberUser);
        Button btn1 = (Button) findViewById(R.id.add);
        numbers = new ArrayList<String>();
        final ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, numbers);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numbers.add(numberUser.getText().toString());
            }
        });

        Button btn2 = (Button) findViewById(R.id.buttonRemove);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayAdapter.clear();
            }
        });

        Button btn3 = (Button) findViewById(R.id.buttonSort);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayAdapter.sort(new Comparator<String>() {
             @Override
             public int compare(String arg1, String arg0) {
                 return arg1.compareTo(arg0);
             }
         });
            }
        });






        // Set The Adapter
        list.setAdapter(arrayAdapter);

        // register onClickListener to handle click events on each item
        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3)
            {
                String selected=numbers.get(position);
                numbers.remove(position);

                Toast.makeText(getApplicationContext(), "Deleted : "+selected,   Toast.LENGTH_LONG).show();
            }
        });
    }




}
