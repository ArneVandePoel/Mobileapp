package be.thomasmore.mobileapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class LuiserActivity extends AppCompatActivity {

    String reeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luiser);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onStart() {

        super.onStart();
        Bundle bundle = getIntent().getExtras();
        reeks = bundle.getString("reeks");
        int geluid = getResources().getIdentifier(reeks, "raw", getPackageName());
        MediaPlayer mediaPlayer = MediaPlayer.create(this, geluid);
        mediaPlayer.start();
    }

}
