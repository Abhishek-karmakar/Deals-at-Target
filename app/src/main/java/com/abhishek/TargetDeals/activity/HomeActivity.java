package com.abhishek.TargetDeals.activity;


import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.abhishek.TargetDeals.R;
import com.abhishek.TargetDeals.fragment.TargetDealsFragment;
/*
@author : Akarmakar
@Description : Home activity where the list will be shown first and various actions can be taken frm there.
Primarily used as a base for Fragments. Go back , open fragments etc.

TODO : later convert to MVP

 */

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    android.app.FragmentManager fragmentManager;
    android.app.FragmentTransaction fragmentTransaction;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        openFragment(new TargetDealsFragment());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_targetdeals) {
           openFragment(new TargetDealsFragment());
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_option_one) {

        } else if (id == R.id.nav_option_two) {

        } else if (id == R.id.nav_option_thre) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /**
     * function to go back to previous fragment
     */
    private void oneStepBack()
    {
        FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() >= 2) {
            fragmentManager.popBackStackImmediate();
            fts.commit();
        } else {
            doubleClickToExit();
        }
    }

    // double back pressed function
    private static long back_pressed;

    private void doubleClickToExit() {
        if ((back_pressed + 2000) > System.currentTimeMillis())
            finish();
        else
            Toast.makeText(HomeActivity.this, "Click again to exit", Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            oneStepBack();
        }

    }

    private void openFragment(Fragment fragment){
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.addToBackStack("searchFragment");
        fragmentTransaction.commit();
    }



}
