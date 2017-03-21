package com.example.yls.andriod0320;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Button btn_show;
    private Button btn_another;
    private FloatingActionButton mFloatingActionButton;
    private NavigationView  mNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


    }

    private void initViews() {
        mDrawerLayout= (DrawerLayout) findViewById(R.id.mdrawerLayout);
        btn_show= (Button) findViewById(R.id.btn_show);
        btn_another= (Button) findViewById(R.id.btn_showToast);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mDrawerLayout,"Hello,I am SnackbarClicked",Snackbar.LENGTH_SHORT).show();

            }
        });
        btn_another.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mDrawerLayout,"SnackbarClicked",Snackbar.LENGTH_LONG).setAction("点我", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"toast once",Toast.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(Color.BLUE).show();

            }
        });
        mFloatingActionButton= (FloatingActionButton) findViewById(R.id.fab_search);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_another.setTextColor(Color.CYAN);
            }
        });
        mNavigationView= (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.navigation_item_home){
                    Toast.makeText(MainActivity.this,"Home",Toast.LENGTH_SHORT).show();
                    return true;
                }
                if(item.getItemId()==R.id.navigation_item_blog){
                    Toast.makeText(MainActivity.this,"Blog",Toast.LENGTH_SHORT).show();
                    return true;
                }
                if(item.getItemId()==R.id.navigation_item_about){
                    Toast.makeText(MainActivity.this,"about",Toast.LENGTH_SHORT).show();
                    return true;
                }
                item.setChecked(true);
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                return false;
            }
        });
    }
}
