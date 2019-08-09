package rcew.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static rcew.application.model.count;
import static rcew.application.model.mark;
import static rcew.application.subj.subject;
import static rcew.application.userlogin.nam;

public class dbmsresult extends AppCompatActivity {

    TextView res,su,rq,wq,per,ff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbmsresult);

        res=(TextView)findViewById(R.id.a1);
        su=(TextView)findViewById(R.id.b1);
        rq=(TextView)findViewById(R.id.c1);
        wq=(TextView)findViewById(R.id.d1);
        per=(TextView)findViewById(R.id.e1);
        ff=(TextView)findViewById(R.id.f1);
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
