package be.thomasmore.mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FourthActivity extends AppCompatActivity {

    String type;
    int kolom;
    int rij;

    String[][] doelklanken = new String[][]{
            {"K-T", "G-S", "NG-N"},
            {"K-T", "G-S/V"},
            {"S-T", "G-S/V"},
            {"G-K", "S/Z-T", "F-T"},
            {"Oeps! Geen spelletjes gevonden. Duw op \"ga terug \" "}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        type = bundle.getString("type");


        if (type.equals("FrontingFinaal")) {
            kolom = 3;
            rij = 0;
            maakLayout();
        } else if (type.equals("FrontingInitiaal")){
            kolom = 2;
            rij = 1;
            maakLayout();
        } else if (type.equals("StoppingFinaal"))
        {
            kolom = 2;
            rij = 2;
            maakLayout();
        } else if (type.equals("StoppingInitiaal"))
        {
            kolom = 3;
            rij = 3;
            maakLayout();
        }
        else{
            TextView textView = (TextView)findViewById(R.id.navigatieError);
            textView.setText(doelklanken[4][0]);
        }
    }

    @Override
    public void onStart() {

        super.onStart();
        Bundle bundle = getIntent().getExtras();
        type = bundle.getString("type");
    }

    private void maakLayout()
    {
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
        for (int i = 0; i < kolom; i++)
        {
            Button button = new Button(this);
            button.setText(doelklanken[rij][i]);
            button.setWidth(10);
            button.setHeight(10);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GaNaarFifthActivity((View)v);
                }
            });
            linearLayout.addView(button);
        }
    }

    public void GaNaarFifthActivity(View v)
    {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        Log.i("Error", "gelukt");
        Intent intent= new Intent(this, FifthActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
