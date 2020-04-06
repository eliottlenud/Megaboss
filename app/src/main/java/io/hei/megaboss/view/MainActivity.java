package io.hei.megaboss.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.hei.megaboss.R;
import io.hei.megaboss.model.Salon;

public class MainActivity extends AppCompatActivity {

    private Button creerSalon;
    private Button buttonValider;
    String Pseudo;
    EditText pseudoecris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonValider = findViewById(R.id.pseudo);
        creerSalon = findViewById(R.id.creerSalon);
        pseudoecris = findViewById(R.id.elpseudo);



        creerSalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Salon.class);
                startActivity(intent);
            }
        });


        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pseudoecris.getText().length()!=0){
                    SetPseudo(v);
                }
                else {
                    final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setMessage("Vous devez rentrer un pseudo !");
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            }

        });

    }

    public void SetPseudo(View v){
        Pseudo = pseudoecris.getText().toString();
        Log.v("la valeur du pseudo est",Pseudo);

    }
}
