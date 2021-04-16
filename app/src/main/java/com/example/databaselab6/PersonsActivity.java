package com.example.databaselab6;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class PersonsActivity extends AppCompatActivity {

    private ListView listView;



    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(R.id.activity_persons);

        listView = findViewById(R.id.personName);

        ArrayList<String> i = {ArrayList}this.getIntent().getExtras().get("Persons");
        ArrayAdapter adapter = new ArrayAdapter((this, android.R.layout.simple_list_item_1,i));
    }
}
