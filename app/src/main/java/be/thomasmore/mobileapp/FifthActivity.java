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
        Intent intent= new Intent(this, FourthActivity.class);
        startActivity(intent);
    }

    public void GaNaarSixsthActivity(View v)
    {
        Bundle bundle = new Bundle();
        type += v.getTag() + "";
        bundle.putString("type", type);


        Intent intent= new Intent(this, FourthActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
