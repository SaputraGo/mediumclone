package com.android.mediumclone;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager viewPager;
    PagerAdapter adapter;
    String[] date;
    String[] time;
    String[] title;
    String[] author;
    int[] bannerimages;

    List<Article> articleList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Generate sample data
        date = new String[] { "Apr 25", "May 2", "Oct 3", "Dec 4" };
        time = new String[] { "12 min read", "2 min read", "13 min read", "4 min read"};

        author = new String[] { "Sylvian", "Jack", "Lucy","Imtiaz"};

        title = new String[] { "The telegraph changed how you spend your time", "The Secret Writing tipsI Learned from Kendrick Lamar",
                "How to use Psychology to solve the Procrastination puzzle ", "Create your First Android App with Kotilin" };


        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        articleList = new ArrayList<>();

        articleList.add(
                new Article(
                        "Based on your reading History",
                        "Remote developer",
                        "Jack",
                "May 6",
                "8 min read",R.drawable.banner1));
        articleList.add(
                new Article(
                        "Freelancing",
                        "Being 3 times dropout.",
                        "Lucy",
                        "May 6",
                        "5 min read",R.drawable.banner2));
        articleList.add(
                new Article(
                        "From your Network",
                        "How to get rid of coding rut",
                        "Lily",
                        "May 6",
                        "3 min read",R.drawable.banner3));
        articleList.add(
                new Article(
                        "Freelancing",
                        "Weekly Digest",
                        "Danny",
                        "May 6",
                        "5 min read",R.drawable.banner4));

        //creating recyclerview adapter
        ArticleAdapter articleadapter = new ArticleAdapter(this, articleList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(articleadapter);

        bannerimages = new int[] { R.drawable.banner1, R.drawable.banner2, R.drawable.banner3, R.drawable.banner4};

        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(MainActivity.this, date, time, author, title,bannerimages);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
