package binarygeek.unixtimestampcounter;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    public RecyclerView itemList;
    CountDownTimer countDownTimer;
    ArrayList<model> models_items = new ArrayList<model>();
    model m1, m2, m3, m4, m5, m6, m7, m8, m9, m10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        m1 = new model();
        m2 = new model();
        m3 = new model();
        m4 = new model();
        m5 = new model();
        m6 = new model();
        m7 = new model();
        m8 = new model();
        m9 = new model();
        m10 = new model();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        itemList = (RecyclerView) findViewById(R.id.items);

        m1.setName("name1");
        m1.setUnixTime(1516863536);

        m2.setName("name2");
        m2.setUnixTime(1516863536);

        m3.setName("name3");
        m3.setUnixTime(1516863536);

        m4.setName("name4");
        m4.setUnixTime(1516863536);

        m5.setName("name5");
        m5.setUnixTime(1516863536);

        m6.setName("name6");
        m6.setUnixTime(1516863536);

        m7.setName("name7");
        m7.setUnixTime(1516863536);

        m8.setName("name8");
        m8.setUnixTime(1516863536);

        m9.setName("name9");
        m9.setUnixTime(1516863536);

        m10.setName("name10");
        m10.setUnixTime(1516863536);


        models_items.add(m1);
        models_items.add(m2);
        models_items.add(m3);
        models_items.add(m4);
        models_items.add(m5);
        models_items.add(m6);
        models_items.add(m7);
        models_items.add(m8);
        models_items.add(m9);
        models_items.add(m10);


        if (models_items.size() > 0 && models_items != null) {
            final Adapter ModelAdapter = new Adapter(models_items);
            LinearLayoutManager MyLayoutManager = new LinearLayoutManager(MainActivity.this);
            MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

            itemList.setAdapter(ModelAdapter);
            itemList.setLayoutManager(MyLayoutManager);

            Thread t = new Thread() {

                @Override
                public void run() {
                    try {
                        while (!isInterrupted()) {
                            Thread.sleep(1000);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    Adapter ModelAdapter = new Adapter(models_items);
                                    ModelAdapter.notifyDataSetChanged();
                                    itemList.setAdapter(ModelAdapter);

                                    // update TextView here!
                                }
                            });
                        }
                    }
                    catch (InterruptedException e) {
                    }
                }
            };

            t.start();


//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Adapter ModelAdapter = new Adapter(models_items);
//                    itemList.setAdapter(ModelAdapter);
////stuff that updates ui
//
//                }
//            });


//            Timer timer = new Timer();
//            timer.schedule(new TimerTask() {
//
//                @Override
//                public void run() {
//                    runOnUiThread(new Runnable() {
//
//                        @Override
//                        public void run() {
//
//                            Handler handler = new Handler();
//                            handler.postDelayed(new Runnable() {
//
//                                @Override
//                                public void run() {
//                                    Adapter ModelAdapter = new Adapter(models_items);
//
//                                }
//                            }, 1000);
//
//                        }
//                    });
//                }
//            }, 0, 1000);
//
//


        }


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);


    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

            return super.onOptionsItemSelected(item);
        }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected (MenuItem item){
            // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
            return true;
        }

    @Override
    protected void onResume() {
        super.onResume();
    }



}

