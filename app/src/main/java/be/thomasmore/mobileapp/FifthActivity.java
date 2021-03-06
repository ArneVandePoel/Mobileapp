package be.thomasmore.mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class FifthActivity extends AppCompatActivity {

    String type;
    String reeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onStart() {

        super.onStart();
        Bundle bundle = getIntent().getExtras();
        type = bundle.getString("type");
    }

    public void GaNaarLuister(View v)
    {
        if(type.equals("StoppingInitiaalS/Z-T"))
        {
            Bundle bundle = new Bundle();
            type+= "luister";
            bundle.putString("type", type);

            Intent intent= new Intent(this,  SixsthActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else{
            Bundle bundle = new Bundle();
            if (type.equals("FrontingFinaalK-T")) {
                reeks = "reeks1";
            }
            else if (type.equals("FrontingFinaalG-S")) {
                reeks = "reeks3";
            }
            else if (type.equals("FrontingFinaalNG-N")) {
                reeks = "reeks5";
            }
            else if (type.equals("FrontingInitiaalK-T")){
                reeks = "reeks2";
            }
            else if (type.equals("FrontingInitiaalG-S/V")){
                reeks = "reeks4";
            }else if (type.equals("StoppingFinaalS-T"))
            {
                reeks = "reeks6";
            }
            else if (type.equals("StoppingFinaalCH-T"))
            {
                reeks = "reeks3";
            }else if (type.equals("StoppingInitiaalG-K"))
            {
                reeks = "reeks4";
            }
            else if (type.equals("StoppingInitiaalF-T"))
            {
                reeks = "reeks9";
            }
            bundle.putString("reeks", reeks);
            Intent intent= new Intent(this, LuiserActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    public void GaNaarSixsthActivity(View v)
    {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);


        Intent intent= new Intent(this, SixsthActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
