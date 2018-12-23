package ru.keos99.littleinsta;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ru.keos99.littleinsta.Fragments.ChangeColorShemeFragment.ChangeColorShemeFragment;
import ru.keos99.littleinsta.Fragments.MainFragment.MainFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        changeFragmentTo(MainFragment.newInstance());
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.nav_main:
                changeFragmentTo(MainFragment.newInstance());
                break;
            case R.id.nav_choose_color:
                changeFragmentTo(ChangeColorShemeFragment.newInstance());
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void changeFragmentTo (Fragment newInstance){
        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_master, newInstance)
                .addToBackStack("Fragment").commit();
    }
}
