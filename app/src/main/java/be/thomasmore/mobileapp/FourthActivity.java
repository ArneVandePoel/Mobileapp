package be.thomasmore.mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
            {"G-K", "S/Z-T", "F-T"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        type = bundle.getString("type");

        if (type == "FrontingFinaal") {
            kolom = 3;
            rij = 0;
        }
        if (type == "FrontingInitiaal"){
            kolom = 2;
            rij = 1;
        }
        if(type =="StoppingFinaal")
        {
            kolom = 2;
            rij = 2;
        }
        if(type == "StoppingInitiaal")
        {
            kolom = 3;
            rij = 3;
        }
        maakLayout();
    }

    private void maakLayout()
    {
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
        for (int i = 0; i < kolom; i++)
        {
            Button button = new Button(this);
            button.setText(doelklanken[rij][kolom]);
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
        Intent intent= new Intent(this, FourthActivity.class);
        startActivity(intent);
    }

}
