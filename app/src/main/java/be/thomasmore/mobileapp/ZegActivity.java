package be.thomasmore.mobileapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ZegActivity extends AppCompatActivity {

    String woord1;
    String woord2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onStart()
    {
        super.onStart();
        Bundle bundle = getIntent().getExtras();
        String mmp = bundle.getString("mmp");
        String[] woorden = mmp.split("-");
        woord1 = woorden[0];
        woord2 = woorden[1];

        for (int i = 0; i < 10; i++)
        {
            ImageView imageView = getResources().getIdentifier("prent" + [i]);
        }
    }





}
