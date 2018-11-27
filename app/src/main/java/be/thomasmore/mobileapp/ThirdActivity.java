package be.thomasmore.mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        type = bundle.getString("type");
    }

    public void GaNaarFourthActivity(View v)
    {
        Bundle bundle = new Bundle();
        type += v.getTag() + "";
        bundle.putString("type", type);


        Intent intent= new Intent(this, FourthActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
