package com.example.covidcasesgreece;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        TextView info = findViewById(R.id.textView);
        info.setText("Αρχή καταγραφής δεδομένων: 21/01/21");

        ListView recordsListView = findViewById(R.id.listview);

        RecordsArrayAdapter recordsArrayAdapter =
                new RecordsArrayAdapter(this,
                        R.layout.list_item,
                        new ArrayList<>(),
                        recordsListView
                );
    }


}