package be.thomasmore.mobileapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SixsthActivity extends AppCompatActivity {

    String type;
    int kolom,rij;
    String[][] minimaalPaar = new String[][]{
            {"bek-bed", "nek-net", "bak-bad"},
            {"buig-buis", "leeg-lees", "dag-das"},
            {"pang-pan", "tong-ton"},
            {"koe-toe", "kou-touw", "kan-tam"},
            {"guus-suus", "goed-voet", "goud-fout"},
            {"boos-boot", "bos-bot"},
            {"pech-pet"},
            {"gat-kat"},
            {"sok-tok", "zak-tak"},
            {"fee-thee", "fien-tien"}
    };
    String reeks;
    int safariColor = Color.parseColor("#E8AB38");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixsth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        type = bundle.getString("type");

        if (type.equals("FrontingFinaalK-T")) {
            kolom = 3;
            rij = 0;
            maakLayout();
        }
        else if (type.equals("FrontingFinaalG-S")) {
            kolom = 3;
            rij = 1;
            maakLayout();
        }
        else if (type.equals("FrontingFinaalNG-N")) {
            kolom = 2;
            rij = 2;
            maakLayout();
        }
        else if (type.equals("FrontingInitiaalK-T")){
            kolom = 3;
            rij = 3;
            maakLayout();
        }
        else if (type.equals("FrontingInitiaalG-S/V")){
            kolom = 3;
            rij = 4;
            maakLayout();
        }else if (type.equals("StoppingFinaalS-T"))
        {
            kolom = 2;
            rij = 5;
            maakLayout();
        }
        else if (type.equals("StoppingFinaalCH-T"))
        {
            kolom = 1;
            rij = 6;
            maakLayout();
        }else if (type.equals("StoppingInitiaalG-K"))
        {
            kolom = 1;
            rij = 7;
            maakLayout();
        }
        else if (type.equals("StoppingInitiaalS/Z-T"))
        {
            kolom = 2;
            rij = 8;
            maakLayout();
        }
        else if (type.equals("StoppingInitiaalF-T"))
        {
            kolom = 2;
            rij = 9;
            maakLayout();
        }
        else if(type.equals("StoppingInitiaalS/Z-Tluister"))
        {
            kolom = 2;
            rij = 8;
            maakLayoutLuister();
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
            button.setText(minimaalPaar[rij][i]);
            button.setTag(minimaalPaar[rij][i]);
            button.setWidth(10);
            button.setHeight(10);
            button.setBackgroundColor(safariColor);
            button.setTextColor(Color.BLACK);
            button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GaNaarZegHetEensZelf((View)v);
                }
            });
            linearLayout.addView(button);
        }
    }
    private void maakLayoutLuister(){
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
        for (int i = 0; i < kolom; i++)
        {
            Button button = new Button(this);
            button.setText(minimaalPaar[rij][i]);
            button.setTag(minimaalPaar[rij][i]);
            button.setWidth(30);
            button.setHeight(10);
            button.setBackgroundColor(safariColor);
            button.setTextColor(Color.BLACK);
            button.setTextSize(25);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GaNaarLuister((View)v);
                }
            });
            linearLayout.addView(button);
        }
    }

    public void GaNaarZegHetEensZelf(View v)
    {
        Bundle bundle = new Bundle();
        String minimaalPaar = (String)v.getTag();
        bundle.putString("mmp",minimaalPaar );
        Intent intent= new Intent(this, ZegActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void GaNaarLuister(View v)
    {
        Bundle bundle = new Bundle();
        if (v.getTag().equals("sok-tok"))
        {
            reeks = "reeks7";
        }
        else if (v.getTag().equals("zak-tak"))
        {
            reeks = "reeks8";
        }
        bundle.putString("reeks", reeks);
        Intent intent= new Intent(this, FifthActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
