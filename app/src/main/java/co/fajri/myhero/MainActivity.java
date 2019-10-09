package co.fajri.myhero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHero;
    private ArrayList<Hero> list = new ArrayList<>();
    private String title = "Indonesian Heroes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //memasang recyclervView
        rvHero = findViewById(R.id.rv_heroList);
        rvHero.setHasFixedSize(true);

        list.addAll(HeroesData.getListData());
        showMenu();

        setActionTitleBar(title);
    }

    private void setActionTitleBar(String title) {
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    //meenghubungkan adapter ke recyclerView
    private void showMenu() {
        rvHero.setLayoutManager(new LinearLayoutManager(this));
        HeroAdapter heroAdapter = new HeroAdapter(list);
        rvHero.setAdapter(heroAdapter);
    }

    //membuat menu pada title bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int selectedMode) {
        switch (selectedMode){
            case R.id.about:
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
                break;
        }
    }
}
