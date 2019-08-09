package rcew.application;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class userlogin extends AppCompatActivity {
    EditText ee1,ee2;
    TextView ttv;
    Button bt,btt;
    mydbms db2;
    static String nam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);
        ee1=(EditText)findViewById(R.id.editText);
        ee2=(EditText)findViewById(R.id.editText3);
        bt=(Button) findViewById(R.id.button);
        ttv=(TextView)findViewById(R.id.textView4);
        btt=(Button)findViewById(R.id.button2);
        db2=new mydbms(this);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String user=ee1.getText().toString();
                    String pass=ee2.getText().toString();
                    if(user.isEmpty()||pass.isEmpty())
                    {

                        Toast.makeText(userlogin.this, "Please Fill All The Details", Toast.LENGTH_SHORT).show();
                    }
                    else if(user.equals("Naincy08")&&pass.equals("081928"))

                    {
                        cln();
                        Intent i=new Intent(userlogin.this,admin.class);
                        Toast.makeText(userlogin.this, "Admin login successful", Toast.LENGTH_SHORT).show();
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(userlogin.this, "Invalid login and password", Toast.LENGTH_SHORT).show();
                    }


                }
                catch (Exception t)
                {
                    Toast.makeText(userlogin.this, "Try Again..", Toast.LENGTH_LONG).show();

                }
            }
        });
        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String user=ee1.getText().toString();
                    String pass=ee2.getText().toString();
                    Cursor cr=db2.login(user,pass);

                    if(user.isEmpty()||pass.isEmpty())
                    {

                        Toast.makeText(userlogin.this, "Please Fill All The Details", Toast.LENGTH_SHORT).show();
                    }


                    else if(cr.getCount()==0)

                    {
                        cln();
                        Toast.makeText(userlogin.this, "Invalid Login And Password", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {

                        cr.moveToFirst();
                        String myemail=cr.getString(1);
                        String mypassword=cr.getString(2);
                        if(myemail.equals(user)&&mypassword.equals(pass))

                        {
                            cln();
                            Intent i=new Intent(userlogin.this,guideline.class);
                            nam=cr.getString(1);



                            Toast.makeText(userlogin.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                            startActivity(i);
                        }

                    }

                }
                catch (Exception t)
                {
                    Toast.makeText(userlogin.this, "Try Again..", Toast.LENGTH_LONG).show();

                }

            }
        });
        ttv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(userlogin.this,registeer.class);
                startActivity(i);
            }
        });

    }


    public void cln()
    {
        ee1.setText(null);
        ee1.requestFocus();
        ee2.setText(null);
    }
}


