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

        for (int i = 0; i < 2; i++)
        {
            ImageView imageantwoordView = (ImageView)findViewById(getResources().getIdentifier("antwoord" + i, "id", getPackageName()));
            imageantwoordView.setImageResource(R.drawable.play);
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
        for (int i = 0; i < 9; i++)
        {
            ImageView imageallView = (ImageView)findViewById(getResources().getIdentifier("prent" + i, "id", getPackageName()));
            imageallView.setOnClickListener(null);
        }
        for (int i = 0; i < 2; i++)
        {
            ImageView imageantwoordView = (ImageView)findViewById(getResources().getIdentifier("antwoord" + i, "id", getPackageName()));
            imageantwoordView.setImageResource(getResources().getIdentifier("optimized" + woorden[i], "drawable", getPackageName()));
            imageantwoordView.setTag(woorden[i]);
        }
    }

    public void Antwoord(View v){
        if (woord == v.getTag()){
            for (int i = 0; i < 2; i++)
            {
                ImageView imageantwoordView = (ImageView)findViewById(getResources().getIdentifier("antwoord" + i, "id", getPackageName()));
                imageantwoordView.setImageResource(R.drawable.play);
                imageantwoordView.setTag("antwoord" + i);
            }
            for (int i = 0; i < 9; i++)
            {
                if ("prent" + i != tag) {
                    ImageView imageallView = (ImageView) findViewById(getResources().getIdentifier("prent" + i, "id", getPackageName()));
                    imageallView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Zeg(v);
                        }
                    });
                }
            }
        }else{
            ImageView imageView = (ImageView)findViewById(getResources().getIdentifier(tag, "id", getPackageName()));
            imageView.setImageResource(R.drawable.varken);
            for (int i = 0; i < 2; i++)
            {
                ImageView imageantwoordView = (ImageView)findViewById(getResources().getIdentifier("antwoord" + i, "id", getPackageName()));
                imageantwoordView.setImageResource(R.drawable.play);
                imageantwoordView.setTag("antwoord" + i);
            }
            for (int i = 0; i < 9; i++)
            {
                ImageView imageallView = (ImageView)findViewById(getResources().getIdentifier("prent" + i, "id", getPackageName()));
                imageallView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Zeg(v);
                    }
                });
            }
        }
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
