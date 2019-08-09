package rcew.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class subj extends AppCompatActivity {
    Button bn1,bn2,bn3,bn4,bn5;
    static  String subject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subj);

        bn1=(Button)findViewById(R.id.button6);
        bn2=(Button)findViewById(R.id.button7);
        bn3=(Button)findViewById(R.id.button8);
        bn4=(Button)findViewById(R.id.button9);
        bn5=(Button)findViewById(R.id.button10);

        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                subject="C";
                Intent i=new Intent(subj.this,model.class);
                startActivity(i);
            }
        });
        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subject="DSA";
                Intent i=new Intent(subj.this,ansdsa.class);
                startActivity(i);
            }
        });
        bn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subject="JAVA";
                Intent i=new Intent(subj.this,ansjava.class);
                startActivity(i);
            }
        });
        bn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subject="DBMS";
                Intent i=new Intent(subj.this,ansdbms.class);
                startActivity(i);
            }
        });
        bn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subject="LINUX";
                Intent i=new Intent(subj.this,anslinux.class);
                startActivity(i);
            }
        });


    }
}
