package rcew.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static rcew.application.model.count;
import static rcew.application.model.mark;
import static rcew.application.subj.subject;
import static rcew.application.userlogin.nam;

public class javaresult extends AppCompatActivity {

    TextView res,su,rq,wq,per,ff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javaresult);

        res=(TextView)findViewById(R.id.a4);
        su=(TextView)findViewById(R.id.b4);
        rq=(TextView)findViewById(R.id.c4);
        wq=(TextView)findViewById(R.id.d4);
        per=(TextView)findViewById(R.id.e4);
        ff=(TextView)findViewById(R.id.f4);
        su.setText(subject);
        ff.setText(nam);
        res.setText(""+mark);
        rq.setText(""+count);
        int w=10-count;
        wq.setText(""+w);
        int mk=(mark*100)/30;
        per.setText(""+mk+"%");
    }
}
