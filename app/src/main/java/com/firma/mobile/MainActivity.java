package com.firma.mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.firma.mobile.app_name";
    private Toolbar topAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation);

        getSupportActionBar().hide();//Ocultar ActivityBar anterior
        topAppBar = (Toolbar)findViewById(R.id.topAppBar);
        //setSupportActionBar(topAppBar);

//        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("TOU AQUI", "TOU AQUI");
//            }
//        });
            //drawerLayout.open()

/*
        navigationView.setNavigationItemSelectedListener { menuItem ->
                // Handle menu item selected
                menuItem.isChecked = true
            drawerLayout.close()
            true
        }*/
    }

}