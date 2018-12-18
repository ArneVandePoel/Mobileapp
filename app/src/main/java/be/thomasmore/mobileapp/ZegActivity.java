package be.thomasmore.mobileapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

public class ZegActivity extends AppCompatActivity {

    String woord1;
    String woord2;
    String[] woorden;
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
        woorden = mmp.split("-");
        woord1 = woorden[0];
        woord2 = woorden[1];

        for (int i = 0; i < 9; i++)
        {
            ImageView imageView = (ImageView)findViewById(getResources().getIdentifier("prent" + i, "id", getPackageName()));
            imageView.setImageResource(R.drawable.varken);
        }
    }


}
