package com.example.localdata.rom;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true) public int id;
    public String nom, postnom, email,matricule;

    public User(int id, String nom, String postnom, String email, String matricule) {
        this.id = id;
        this.nom = nom;
        this.postnom = postnom;
        this.email = email;
        this.matricule = matricule;
    }
    public User(String nom, String postnom, String email, String matricule) {

        this.nom = nom;
        this.postnom = postnom;
        this.email = email;
        this.matricule = matricule;
    }
    public User() {
    }
}
