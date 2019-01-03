package be.thomasmore.mobileapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ZegActivity extends AppCompatActivity {

    String woord1;
    String woord2;
    String[] woorden;
    String woord;
    MediaPlayer mediaPlayer;
    String tag;

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

        mediaPlayer = MediaPlayer.create(this, R.raw.spel3);
        mediaPlayer.start();
    }

    public void Zeg(View v){
        stopPlaying();
        int random = new Random().nextInt(2);
        woord = woorden[random];
        int geluid = getResources().getIdentifier(woord, "raw", getPackageName());
        mediaPlayer = MediaPlayer.create(this, geluid);
        mediaPlayer.start();
        tag = v.getTag() + "";
        ImageView imageView = (ImageView)findViewById(getResources().getIdentifier(tag, "id", getPackageName()));
        imageView.setImageResource(getResources().getIdentifier(woord, "drawable", getPackageName()));
    }

    public void onPause()
    {
        super.onPause();
        stopPlaying();

    }

    private void stopPlaying() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
