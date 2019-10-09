package co.fajri.myhero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailHero extends AppCompatActivity {

    //penangkap data
    public static final String POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hero);

        //menangkap data yang dilempar oleh adapter
        int pos = getIntent().getIntExtra(POSITION,0);

        //mengambil struktur data dari model
        Hero hero = HeroesData.getListData().get(pos);

        //mendeklarasikan layout
        ImageView foto_hero = findViewById(R.id.img_hero_foto);
        TextView detail_hero = findViewById(R.id.detail_hero);

        //memasang data
        Glide.with(this)
                .load(hero.getFoto())
                .apply(new RequestOptions().override(150,200))
                .into(foto_hero);
        detail_hero.setText(hero.getDetail());

        setActionTitleBar(hero.getNama());
    }

    //pendeklarasian title bar
    private void setActionTitleBar(String title) {
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }
}
