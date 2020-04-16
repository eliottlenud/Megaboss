package io.hei.megaboss.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import io.hei.megaboss.R;
import io.hei.megaboss.Salon;

public class MainActivity extends AppCompatActivity {

    private Button creerSalon;
    private Button buttonValider;
    String Pseudo;
    EditText pseudoecris;

    private static final String DB_URL = "jdbc:mysql://54.37.121.232/hjhhfdedb";
    private static final String USER = "hjhhfdedb";
    private static final String PASS = "hbWP7jLhtf2GhW4";

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

    // envoyer des données dans la BDD

    public void ConnectButton(View view){
        Send objSend = new  Send();
        objSend.execute("");

    }

    private class Send extends AsyncTask<String, String, String>{
        String msg ="";
        String text = pseudoecris.getText().toString();

        @Override
        protected  void onPreExecute (){
            pseudoecris.setText("Please wait inserting data");
        }

        @Override
        protected  String doInBackground(String... strings){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                if (conn ==null){
                    msg= "connection goes wrong";
                } else {
                    String query = "ISERT INTO joueur (pseudo) VALUES('"+text+"') ";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(query);
                    msg= "pseudo inséré";

                }
                conn.close();

            } catch (Exception e) {
                msg= "connection ne va pas";
                e.printStackTrace();
            }
            return msg;
        }

        @Override
        protected void onPostExecute(String msg) {
            pseudoecris.setText(msg);
        }
    }

    public void SetPseudo(View v){
        Pseudo = pseudoecris.getText().toString();
        Log.v("la valeur du pseudo est",Pseudo);

    }
}
