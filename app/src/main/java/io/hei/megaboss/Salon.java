package io.hei.megaboss;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

//import com.google.android.gms.cast.framework.CastButtonFactory;
//import com.google.android.gms.cast.framework.CastContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Salon extends AppCompatActivity {
    private Button e;
    private static Socket s;
    private static ServerSocket ss;
    private static InputStreamReader isr;
    private static PrintWriter pw;
    private static BufferedReader br;
    String message = "e";
    private static String ip = "54.37.121.232";
    //private CastContext mCastContext;
    private MenuItem mediaRouteMenuItem;
    private Toolbar mToolbar;

   /* @Override
    *//*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salon);
        e = findViewById(R.id.e);
        setupActionBar();

        mCastContext = CastContext.getSharedInstance(this);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_text(v);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.browse, menu);
        mediaRouteMenuItem = CastButtonFactory.setUpMediaRouteButton(getApplicationContext(), menu, R.id.media_route_menu_item);
        return true;
    }*/

    public void send_text(View v){
        myTask mt = new myTask();
        mt.execute();
        Toast.makeText(getApplicationContext(),"Data sent",Toast.LENGTH_LONG).show();
    }

    class myTask extends AsyncTask<Void, Void, Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                s = new Socket(ip, 5000);
                pw = new PrintWriter(s.getOutputStream());
                pw.write(message);
                pw.flush();
                pw.close();
                s.close();

                return null;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }

   /* private void setupActionBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);
        setSupportActionBar(mToolbar);
    }*/
}

