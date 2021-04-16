package com.stingersof.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.stingersof.roomdatabase.asyncs.AddPersonAsync;
import com.stingersof.roomdatabase.asyncs.GetAllPersonsAsync;
import com.stingersof.roomdatabase.database.LabDatabase;
import com.stingersof.roomdatabase.entity.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    private Button addPersonButton;
    private Button getAllPersonsButton;

    private LabDatabase labDB;
    private String DATABASE_NAME = "DemoPerson";

    public static ArrayList<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        addPersonButton = findViewById(R.id.add_person_button);
        getAllPersonsButton = findViewById(R.id.get_all_persons_button);


        labDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME)
                .build();


        addPersonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AddPersonAsync addPersonAsync = new AddPersonAsync(labDB);

                Person person = new Person();
                person.setName(editText.getText().toString());
                addPersonAsync.execute(person);

                editText.setText("");
            }
        });

        getAllPersonsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final GetAllPersonsAsync getAllPersonsAsync = new GetAllPersonsAsync(labDB, getApplicationContext());
                getAllPersonsAsync.execute();




            }
        });


    }
}