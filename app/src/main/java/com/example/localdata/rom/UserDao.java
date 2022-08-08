package com.example.localdata.rom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);
    @Delete
    void delete(User user);
    @Update
    void update(User user);
    @Query("select * from User Where id = :id")
    User findOne(int id);
    @Query("select * from User order by nom ASC LIMIT 10")
    List<User> findAll();


}
