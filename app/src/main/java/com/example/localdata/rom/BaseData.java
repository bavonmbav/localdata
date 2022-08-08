package com.example.localdata.rom;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
        entities = {User.class},
        version = 1
)
public abstract class BaseData extends RoomDatabase {
    public  abstract  UserDao usedeo();
}
