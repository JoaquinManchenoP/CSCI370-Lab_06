package com.stingersof.roomdatabase.asyncs;

import android.os.AsyncTask;

import com.stingersof.roomdatabase.database.LabDatabase;
import com.stingersof.roomdatabase.entity.Person;

public class AddPersonAsync extends AsyncTask<Person, Void, Void> {
    private LabDatabase database;

    public AddPersonAsync(LabDatabase database) {
        this.database = database;
    }

    @Override
    protected Void doInBackground(Person... people) {

        database.personDao().insertPerson(people[0]);
        return null;
    }
}