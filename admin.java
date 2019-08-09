package rcew.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class admin extends AppCompatActivity {
    EditText et1, et2, et3, et4, et5, et6;
    Button bttt;
    mydbms dbb;
    String x;
    Spinner sp;
    String sub[] = {"Select Topic", "C", "DSA", "JAVA", "DBMS", "LINUX"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        et1 = (EditText) findViewById(R.id.editText2);
        et2 = (EditText) findViewById(R.id.editText4);
        et3 = (EditText) findViewById(R.id.editText5);
        et4 = (EditText) findViewById(R.id.editText6);
        et5 = (EditText) findViewById(R.id.editText7);
        et6 = (EditText) findViewById(R.id.editText8);
        bttt = (Button) findViewById(R.id.button3);
        dbb = new mydbms(this);

        sp = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> obj;
        obj = new ArrayAdapter<String>(admin.this, R.layout.support_simple_spinner_dropdown_item, sub);
        sp.setAdapter(obj);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                x = String.valueOf(parent.getItemAtPosition(i));
                Toast.makeText(admin.this, "" + x, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        bttt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x.equals("C")) {

                    dbb.add_quiz(et1.getText().toString(), et2.getText().toString(), et3.getText().toString(), et4.getText().toString(), et5.getText().toString(), et6.getText().toString());

                    Toast.makeText(admin.this, "Inserted...", Toast.LENGTH_SHORT).show();

                    et6.setText(null);
                    et5.setText(null);
                    et4.setText(null);
                    et3.setText(null);
                    et2.setText(null);
                    et1.setText(null);
                } else if (x.equals("DSA")) {

                    dbb.add_quiz1(et1.getText().toString(), et2.getText().toString(), et3.getText().toString(), et4.getText().toString(), et5.getText().toString(), et6.getText().toString());

                    Toast.makeText(admin.this, "Inserted...", Toast.LENGTH_SHORT).show();

                    et6.setText(null);
                    et5.setText(null);
                    et4.setText(null);
                    et3.setText(null);
                    et2.setText(null);
                    et1.setText(null);
                    et1.requestFocus();
                } else if (x.equals("JAVA")) {

                    dbb.add_quiz2(et1.getText().toString(), et2.getText().toString(), et3.getText().toString(), et4.getText().toString(), et5.getText().toString(), et6.getText().toString());

                    Toast.makeText(admin.this, "Inserted...", Toast.LENGTH_SHORT).show();

                    et6.setText(null);
                    et5.setText(null);
                    et4.setText(null);
                    et3.setText(null);
                    et2.setText(null);
                    et1.setText(null);
                    et1.requestFocus();
                }
                else if (x.equals("DBMS")) {

                    dbb.add_quiz3(et1.getText().toString(), et2.getText().toString(), et3.getText().toString(), et4.getText().toString(), et5.getText().toString(), et6.getText().toString());

                    Toast.makeText(admin.this, "Inserted...", Toast.LENGTH_SHORT).show();

                    et6.setText(null);
                    et5.setText(null);
                    et4.setText(null);
                    et3.setText(null);
                    et2.setText(null);
                    et1.setText(null);
                    et1.requestFocus();
                }

                else if (x.equals("LINUX")) {

                    dbb.add_quiz4(et1.getText().toString(), et2.getText().toString(), et3.getText().toString(), et4.getText().toString(), et5.getText().toString(), et6.getText().toString());

                    Toast.makeText(admin.this, "Inserted...", Toast.LENGTH_SHORT).show();

                    et6.setText(null);
                    et5.setText(null);
                    et4.setText(null);
                    et3.setText(null);
                    et2.setText(null);
                    et1.setText(null);
                    et1.requestFocus();
                }



            }
        });


    }
}
