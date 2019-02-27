package ru.keos99.littleinsta.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.keos99.littleinsta.mvp.Presenter.MainViewPresenter;
import ru.keos99.littleinsta.mvp.view.MainView;
import ru.keos99.littleinsta.ui.activity.Fragments.MainFragment;
import ru.keos99.littleinsta.R;


public class MainActivity extends MvpAppCompatActivity implements MainView, NavigationView.OnNavigationItemSelectedListener {

    @InjectPresenter
    MainViewPresenter mainViewPresenter;
    private DrawerLayout drawer;
    private View view;

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
