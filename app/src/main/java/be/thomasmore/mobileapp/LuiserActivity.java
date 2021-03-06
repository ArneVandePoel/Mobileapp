package be.thomasmore.mobileapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.media.MediaPlayer.OnCompletionListener;

public class LuiserActivity extends AppCompatActivity {

    String reeks;
    int geluid;
    MediaPlayer mediaPlayer;
    MediaPlayer flink;

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
        geluid = getResources().getIdentifier(reeks, "raw", getPackageName());
        mediaPlayer = MediaPlayer.create(this, R.raw.spel1);
        mediaPlayer.start();
        flink = MediaPlayer.create(this, R.raw.flinkgeluisterd);
    }

    public void onPause()
    {
        super.onPause();
        stopPlaying();

    }

    public void Luister(View v){
        stopPlaying();
        mediaPlayer = MediaPlayer.create(this, geluid);
        mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlaying();
                flink.start();
            }
        });
        mediaPlayer.start();

    }

    private void stopPlaying() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
