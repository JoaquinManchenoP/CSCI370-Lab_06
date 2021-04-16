package com.stingersof.roomdatabase.asyncs;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.stingersof.roomdatabase.MainActivity;
import com.stingersof.roomdatabase.PersonsActivity;
import com.stingersof.roomdatabase.database.LabDatabase;
import com.stingersof.roomdatabase.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class GetAllPersonsAsync extends AsyncTask<Void, Void, List<Person>> {
    private LabDatabase database;
    private ArrayList<Person> personArrayList;
    private Context context;

    public GetAllPersonsAsync(LabDatabase labDatabase, Context context) {
        this.database = labDatabase;
        this.context = context;
    }

    @Override
    protected List<Person> doInBackground(Void... voids) {
        ArrayList<String> personNames = new ArrayList<>();

        personArrayList = (ArrayList)database.personDao().getAllPersons();
        for(int i=0; i<personArrayList.size(); i++) {
            personNames.add(personArrayList.get(i).getName());
        }

        Intent i = new Intent(context, PersonsActivity.class);
        i.putExtra("Persons", personNames);
        context.startActivity(i);
        return null;
    }


}