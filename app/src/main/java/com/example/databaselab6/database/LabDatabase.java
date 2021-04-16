package com.stingersof.roomdatabase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.stingersof.roomdatabase.dao.PersonDao;
import com.stingersof.roomdatabase.entity.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class LabDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
}