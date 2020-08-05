package com.example.gymapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ActivityMain extends AppCompatActivity {
    RelativeLayout placeholderLayout;
    BottomNavigationView bottomNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeholderLayout = (RelativeLayout)findViewById(R.id.placeholder);
        bottomNav = (BottomNavigationView)findViewById(R.id.bottom_nav);

        setBottomNav();
        setInitialFragment();
    }

    private void setBottomNav(){
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


                switch(itemId) {
                    case R.id.navigationExplore:
                        FragmentExplore fragmentExplore = new FragmentExplore();
                        fragmentTransaction.replace(R.id.placeholder, fragmentExplore);
                        fragmentTransaction.commit();
                        setActionBarTitle("Explore");
                        return true;
                    case R.id.navigationWorkout:
                        FragmentWorkout fragmentWorkout = new FragmentWorkout();
                        fragmentTransaction.replace(R.id.placeholder, fragmentWorkout);
                        fragmentTransaction.commit();
                        setActionBarTitle("Workout");
                        return true;
                    case R.id.navigationFindATrainer:
                        FragmentFindTrainer fragmentFindTrainer = new FragmentFindTrainer();
                        fragmentTransaction.replace(R.id.placeholder, fragmentFindTrainer);
                        fragmentTransaction.commit();
                        setActionBarTitle("Find a Trainer");
                        return true;
                }
                return false;
            }
        });
    }

    private void setInitialFragment(){
        FragmentExplore fragmentExplore = new FragmentExplore();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.placeholder, fragmentExplore);
        fragmentTransaction.commit();
        setActionBarTitle("Explore");

    }

    protected void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
