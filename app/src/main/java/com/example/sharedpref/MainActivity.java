package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private EditText etnom,etprenom;
  private Button btnsave,btnclear;
   private SharedPreferences sh ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sh= getSharedPreferences("MySharedPref", MODE_PRIVATE);
        etnom = findViewById(R.id.nom);
        etprenom = findViewById(R.id.prenom);
        btnsave = findViewById(R.id.save);
        btnclear = findViewById(R.id.clear);

        if (sh.contains("nom") && sh.contains("prenom")){
            etnom.setText(sh.getString("nom",""));
            etprenom.setText(sh.getString("prenom",""));
        }

        btnsave.setOnClickListener(e ->{
            SharedPreferences.Editor editor = sh.edit();
            editor.putString("nom",etnom.getText().toString());
            editor.putString("prenom",etprenom.getText().toString());
            editor.commit();
            Toast.makeText(this,"Données enregistrées avec succès",Toast.LENGTH_LONG).show();

        });
        btnclear.setOnClickListener(e ->{
            SharedPreferences.Editor editor = sh.edit();
            editor.clear();
            editor.commit();
            Toast.makeText(this,"les données ont été supprimées",Toast.LENGTH_LONG).show();

            etnom.setText("");
            etprenom.setText("");
        });
    }
}