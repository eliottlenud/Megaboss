package io.hei.megaboss.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.hei.megaboss.R;
import io.hei.megaboss.model.Salon;

public class MainActivity extends AppCompatActivity {

    private Button creerSalon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creerSalon = findViewById(R.id.creerSalon);
        creerSalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Salon.class);
                startActivity(intent);
            }
        });


    }
}
