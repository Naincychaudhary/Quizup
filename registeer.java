package rcew.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registeer extends AppCompatActivity {

    EditText e1,e2,e3,e4;
    Button be;
    static String s1,s2,s3,s4;
    mydbms db1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeer);


        e1 = (EditText) findViewById(R.id.editText9);
        e2 = (EditText) findViewById(R.id.editText10);
        e3 = (EditText) findViewById(R.id.editText11);
        e4 = (EditText) findViewById(R.id.editText13);
        be = (Button) findViewById(R.id.button4);
        db1 = new mydbms(this);
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    s1 = e1.getText().toString();
                    s2 = e2.getText().toString();
                    s3 = e3.getText().toString();
                    s4 = e4.getText().toString();
                    if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty()) {
                        Toast.makeText(registeer.this, "ALL FIELDS ARE MANDATORY", Toast.LENGTH_SHORT).show();
                    } else {


                        db1.insert(s2, s4);
                        cln();
                        Intent i = new Intent(registeer.this, userlogin.class);
                        startActivity(i);

                    }
                } catch (Exception t) {
                    Toast.makeText(registeer.this, "Error" + t, Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(registeer.this, "Registration Successful", Toast.LENGTH_SHORT).show();


            }
        });
    }


    public void cln ()
    {
        e1.setText(null);
        e1.requestFocus();
        e2.setText(null);
        e3.setText(null);
        e4.setText(null);
    }
}

