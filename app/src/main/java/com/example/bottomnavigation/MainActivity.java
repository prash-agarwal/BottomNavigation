package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.bottomnavigation.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Hides the status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding.navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.add(R.id.container,new SearchFragment());

                if(id==R.id.nav_home){
//                  loadFrag(new HomeFragment(),false);
                    ft.replace(R.id.container,new HomeFragment());

                } else if (id==R.id.nav_contact) {
//                    loadFrag(new SearchFragment(),false);
                    ft.replace(R.id.container,new SearchFragment());
                }
                else if (id==R.id.nav_utilities){
//                    loadFrag(new UtilitiesFragment(),false);
                    ft.replace(R.id.container,new UtilitiesFragment());
                }
                else {
//                    loadFrag(new ContactFragment(),true);
                    ft.replace(R.id.container,new ContactFragment());
                }
                ft.commit();
                return true;
            }
        });
        binding.navigation.setSelectedItemId(R.id.nav_home);


    }
//    public void loadFrag(Fragment fragment, boolean flag){
//        FragmentManager fm=getSupportFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction();
//        if (flag)
//            ft.add(R.id.navigation,fragment);
//        else
//            ft.replace(R.id.navigation,fragment);
//        ft.commit();
//    }
}