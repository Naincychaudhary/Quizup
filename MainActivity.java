package rcew.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread obj=new Thread()
        {
          public void run()
          {
              try{
                  sleep(3000);
              }
              catch (Exception t)
              {
                  Toast.makeText(MainActivity.this, "Error"+t, Toast.LENGTH_SHORT).show();
              }
              finally {
                  Intent i=new Intent(MainActivity.this,userlogin.class);
                  startActivity(i);
                  finish();
              }
          }


        };
        obj.start();
    }
}
