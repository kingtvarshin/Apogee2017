package com.kingtvarshin.apogee2017;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kingtvarshin.apogee2017.Fragments.Fragment_about;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    android.support.v4.app.Fragment fragment = null;
    boolean exit=false;
    SupportMapFragment sMapFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sMapFragment = SupportMapFragment.newInstance();

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragment = new Fragment_about();

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        sMapFragment.getMapAsync(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (!drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.openDrawer(GravityCompat.START);
            Toast.makeText(MainActivity.this, "Press Again to Exit", Toast.LENGTH_SHORT).show();
            exit = true;
            return;
        }
        else if(!exit && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
        }

        if(exit)
            System.exit(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        android.support.v4.app.FragmentManager sFm = getSupportFragmentManager();

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (sMapFragment.isAdded())
            sFm.beginTransaction().hide(sMapFragment).commit();


        if (id == R.id.nav_about) {
            setTitle("About");
            fragment = new Fragment_about();
            fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        } else if (id == R.id.nav_event) {

        }else if (id == R.id.nav_map) {
            setTitle("Map");
            if (!sMapFragment.isAdded()) {
                sFm.beginTransaction().add(R.id.content_frame, sMapFragment).commit();
            } else {
                sFm.beginTransaction().show(sMapFragment).commit();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // Add a marker in Sydney and move the camera
        LatLng clocktower = new LatLng(28.363821, 75.587029);
        googleMap.addMarker(new MarkerOptions().position(clocktower).title("Clock Tower"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(clocktower,17));
        //googleMap.setMyLocationEnabled(true);

        LatLng Library = new LatLng(28.363821, 75.587029);
        googleMap.addMarker(new MarkerOptions().position(Library).title("Library"));

        LatLng FD2 = new LatLng(28.364074, 75.588062);
        googleMap.addMarker(new MarkerOptions().position(FD2).title("FD2"));

        LatLng FD3 = new LatLng(28.363854, 75.585854);
        googleMap.addMarker(new MarkerOptions().position(FD3).title("FD3"));

        LatLng SAC = new LatLng(28.360647, 75.585401);
        googleMap.addMarker(new MarkerOptions().position(SAC).title("SAC"));

        LatLng Gym_G = new LatLng(28.359127, 75.590132);
        googleMap.addMarker(new MarkerOptions().position(Gym_G).title("Gym_G"));

        LatLng Birla_mandir = new LatLng(28.357635, 75.588115);
        googleMap.addMarker(new MarkerOptions().position(Birla_mandir).title("Birla_mandir"));


    }
}
