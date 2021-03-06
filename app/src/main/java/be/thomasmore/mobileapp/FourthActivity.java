package be.thomasmore.mobileapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    String type;
    int kolom;
    int rij;
    int safariColor = Color.parseColor("#E8AB38");

    String[][] doelklanken = new String[][]{
            {"K-T", "G-S", "NG-N"},
            {"K-T", "G-S/V"},
            {"S-T", "CH-T"},
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
            button.setTag(doelklanken[rij][i]);
            button.setWidth(10);
            button.setHeight(10);
            button.setBackgroundColor(safariColor);
            button.setTextColor(Color.BLACK);
            button.setTextSize(25);
            button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
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
        type += v.getTag() + "";
        bundle.putString("type", type);
        Intent intent= new Intent(this, FifthActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
