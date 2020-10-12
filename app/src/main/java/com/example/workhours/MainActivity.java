package com.example.workhours;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.workhours.Fragments.April;
import com.example.workhours.Fragments.August;
import com.example.workhours.Fragments.December;
import com.example.workhours.Fragments.February;
import com.example.workhours.Fragments.January;
import com.example.workhours.Fragments.July;
import com.example.workhours.Fragments.June;
import com.example.workhours.Fragments.March;
import com.example.workhours.Fragments.May;
import com.example.workhours.Fragments.November;
import com.example.workhours.Fragments.October;
import com.example.workhours.Fragments.September;
import com.example.workhours.Recycler.VerticalRecyclerAdapter;
import com.example.workhours.Recycler.VerticalRecyclerModel;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;
    TabLayout tab_layout;
    ViewPager view_pager;
    TextView hours_amount_text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        view_pager = findViewById(R.id.single_view_pager);
        tab_layout = findViewById(R.id.month_tab_layout);

        tab_layout.setupWithViewPager(view_pager, false);
        tab_layout.setTabGravity(TabLayout.GRAVITY_FILL);
        // ADD TAB LISTENER TO TAB LAYOUT (only logs)
        tab_layout.addOnTabSelectedListener(listener());

        hours_amount_text_view = findViewById(R.id.hours_amount_view);

        // SET VIEW PAGER ACTIVITY TO FRAGMENT'S
        this.add_pages(view_pager);
    }

    // ADD ALL PAGES
    private void add_pages(ViewPager pager) {
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager(), 1);

            adapter.add_page(new January());
            adapter.add_page(new February());
            adapter.add_page(new March());
            adapter.add_page(new April());
            adapter.add_page(new May());
            adapter.add_page(new June());
            adapter.add_page(new July());
            adapter.add_page(new August());
            adapter.add_page(new September());
            adapter.add_page(new October());
            adapter.add_page(new November());
            adapter.add_page(new December());


        pager.setAdapter(adapter);
    }

    /* TabLayout Item listener. This method can display actual selected tab item,
    * but result is displayed only in Logs*/

    private static TabLayout.OnTabSelectedListener listener() {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("SELECTED_MONTH_POSITION", String.valueOf(position));
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        MenuItem item = menu.findItem(R.id.spinner);

        // Cast spinner dialog to menu
        Spinner spinner = (Spinner) item.getActionView();

        // Create an array of two years, actual and previous
        ArrayList<String> years = new ArrayList<>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = thisYear; i >= thisYear - 1; i--) {
            years.add(Integer.toString(i));
        }
        // Add years to dropdown items adapter
        ArrayAdapter<String> years_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, years);
        spinner.setAdapter(years_adapter);
        return true;
    }
}





