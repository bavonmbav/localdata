package com.example.localdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.localdata.rom.BaseData;
import com.example.localdata.rom.User;
import com.example.localdata.rom.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText noms, postnoms,emails,matricule, supp;
    private Button validation, supprime;
    private TextView messege;
    private ProgressBar bare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        click();
    }

    void initialize()
    {
        noms = findViewById(R.id.nomUser);
        postnoms = findViewById(R.id.postnomUser);
        emails = findViewById(R.id.emailUser);
        matricule = findViewById(R.id.matriculeUser);
        validation = findViewById(R.id.valider);
//        supprime = findViewById(R.id.Deletes);
//        supp  = findViewById(R.id.Deletematricule);
        messege = findViewById(R.id.info);
        bare = findViewById(R.id.progrsse);

    }
    void click()
    {
        validation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = noms.getText().toString(),
                        postnom = postnoms.getText().toString(),
                        email = emails.getText().toString(),
                        matricules = matricule.getText().toString();

                if(nom.isEmpty() && postnom.isEmpty() && email.isEmpty() && matricules.isEmpty())
                {
                    Toast.makeText(
                            MainActivity.this,
                            "completez les cases",
                            Toast.LENGTH_SHORT
                    ).show();
                    bare.setVisibility(View.GONE);
                }else if(nom.isEmpty() || postnom.isEmpty() || email.isEmpty() || matricules.isEmpty() )
                {
                    Toast.makeText(
                            MainActivity.this,
                            "completez les cases vident",
                            Toast.LENGTH_SHORT
                    ).show();
                    bare.setVisibility(View.GONE);
                }
                else {
                    enregistre(nom, postnom,email,matricules);
                    bare.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    void enregistre(String nm, String postn,String emai, String matri )
    {
        User user = new User(nm, postn, emai, matri);

        BaseData date = Room.databaseBuilder(this,
                        BaseData.class,
                        "db")
                .allowMainThreadQueries()
                .build();
        UserDao deo = date.usedeo();
         //insert dans la base de donnee
        deo.insert(user);
        //afficher les donnees
        //deo.findOne(1);
        List<User>matr = deo.findAll();
        String text = messege.getText().toString();
        StringBuilder string = new StringBuilder();

        for(User mt : matr)
        {
            messege.setText("Matricule : " + string.append(mt.matricule+"\n"));
        }

    }
}