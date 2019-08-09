package rcew.application;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ansdbms extends AppCompatActivity {


    TextView ttt1,ttt2,ttt3;
    RadioGroup rr1;
    int i=1;
    int k=1;
    static int mark=0,count=0;
    RadioButton rd1,rd2,rd3,rd4,res;
    Button butt1,butt2;
    mydbms bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ansdbms);


        ttt1=(TextView)findViewById(R.id.txt7);
        ttt2=(TextView)findViewById(R.id.txt8);
        ttt3=(TextView)findViewById(R.id.vg);
        rr1=(RadioGroup)findViewById(R.id.vgv);
        rd1=(RadioButton)findViewById(R.id.rado);
        rd2=(RadioButton)findViewById(R.id.rado2);
        rd3=(RadioButton)findViewById(R.id.rado3);
        rd4=(RadioButton)findViewById(R.id.rado4);
        butt1=(Button)findViewById(R.id.butons11);
        butt2=(Button)findViewById(R.id.butons12);
        bd=new mydbms(this);
        try{

            Cursor c=bd.get_quiz3(i);

            if(c.getCount()==0){

                Toast.makeText(this, "data Not Found", Toast.LENGTH_SHORT).show();
            }

            else{

                c.moveToFirst();

                ttt3.setText(c.getString(1));
                rd1.setText(c.getString(2));
                rd2.setText(c.getString(3));
                rd3.setText(c.getString(4));
                rd4.setText(c.getString(5));
                ttt1.setText("QUESTION " + i);


                rd1.setChecked(true);
            }

        }catch (Exception t)
        {
            mark=mark+3;
            Toast.makeText(this, "Error"+t, Toast.LENGTH_SHORT).show();

        }


        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i < 10) {
                    int id = rr1.getCheckedRadioButtonId();
                    res = findViewById(id);
                    Cursor cu = bd.get_quiz3(i);
                    cu.moveToFirst();
                    String result = res.getText().toString();
                    if (result.equals(cu.getString(6))) {
                        mark = mark + 3;
                        count++;
                        Toast.makeText(ansdbms.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ansdbms.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    }


                    i++;
                    if (k < 10) {
                        try {

                            Cursor c = bd.get_quiz3(i);

                            if (c.getCount() == 0) {

                                Toast.makeText(ansdbms.this, "data Not Found", Toast.LENGTH_SHORT).show();
                            } else {

                                c.moveToFirst();

                                ttt3.setText(c.getString(1));
                                rd1.setText(c.getString(2));
                                rd2.setText(c.getString(3));
                                rd3.setText(c.getString(4));
                                rd4.setText(c.getString(5));
                                ttt1.setText("QUESTION " + i);
                            }

                        } catch (Exception t) {

                        }


                    }
                } else {
                    Intent j = new Intent(ansdbms.this, dbmsresult.class);
                    int id = rr1.getCheckedRadioButtonId();
                    res = findViewById(id);
                    Cursor cu = bd.get_quiz3(i);
                    cu.moveToFirst();
                    String result = res.getText().toString();
                    if (result.equals(cu.getString(6))) {
                        mark = mark + 3;
                        count++;
                        Toast.makeText(ansdbms.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    }
                    startActivity(j);

                }
            }
        });

        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ansdbms.this, "You Skipped this question", Toast.LENGTH_SHORT).show();
                i++;
                if(k<10)
                {
                    try{
                        Cursor c=bd.get_quiz3(i);
                        c.moveToFirst();
                        ttt3.setText(c.getString(1));
                        rd1.setText(c.getString(2));
                        rd2.setText(c.getString(3));
                        rd3.setText(c.getString(4));
                        rd4.setText(c.getString(5));
                        ttt1.setText("QUESTION" + i);
                        rd1.setChecked(true);
                        k++;
                    }
                    catch (Exception t)
                    {

                    }
                }
                else {
                    Intent j=new Intent(ansdbms.this,dbmsresult.class);
                    Toast.makeText(ansdbms.this, "You skipped this question", Toast.LENGTH_SHORT).show();
                    startActivity(j);
                }

            }
        });
    }

}
