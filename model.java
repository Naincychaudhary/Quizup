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

public class model extends AppCompatActivity {
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
        setContentView(R.layout.activity_model);


        ttt1=(TextView)findViewById(R.id.textView7);
        ttt2=(TextView)findViewById(R.id.textView8);
        ttt3=(TextView)findViewById(R.id.tv);
        rr1=(RadioGroup)findViewById(R.id.rg);
        rd1=(RadioButton)findViewById(R.id.radioButton);
        rd2=(RadioButton)findViewById(R.id.radioButton2);
        rd3=(RadioButton)findViewById(R.id.radioButton3);
        rd4=(RadioButton)findViewById(R.id.radioButton4);
        butt1=(Button)findViewById(R.id.button11);
        butt2=(Button)findViewById(R.id.button12);
        bd=new mydbms(this);
        try{

            Cursor c=bd.get_quiz(i);

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
                    Cursor cu = bd.get_quiz(i);
                    cu.moveToFirst();
                    String result = res.getText().toString();
                    if (result.equals(cu.getString(6))) {
                        mark = mark + 3;
                        count++;
                        Toast.makeText(model.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(model.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    }


                    i++;
                    if (k < 10) {
                        try {

                            Cursor c = bd.get_quiz(i);

                            if (c.getCount() == 0) {

                                Toast.makeText(model.this, "data Not Found", Toast.LENGTH_SHORT).show();
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
                    Intent j = new Intent(model.this, finall.class);
                    int id = rr1.getCheckedRadioButtonId();
                    res = findViewById(id);
                    Cursor cu = bd.get_quiz(i);
                    cu.moveToFirst();
                    String result = res.getText().toString();
                    if (result.equals(cu.getString(6))) {
                        mark = mark + 3;
                        count++;
                        Toast.makeText(model.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    }
                    startActivity(j);

                }
            }
        });

        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(model.this, "You Skipped this question", Toast.LENGTH_SHORT).show();
                i++;
                if(k<10)
                {
                    try{
                        Cursor c=bd.get_quiz(i);
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
                    Intent j=new Intent(model.this,finall.class);
                    Toast.makeText(model.this, "You skipped this question", Toast.LENGTH_SHORT).show();
                    startActivity(j);
                }

            }
        });
    }
}
