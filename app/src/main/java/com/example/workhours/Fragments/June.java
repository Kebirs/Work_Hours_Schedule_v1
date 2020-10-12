package com.example.workhours.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workhours.R;
import com.example.workhours.Recycler.VerticalRecyclerAdapter;
import com.example.workhours.Recycler.VerticalRecyclerModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class June extends Fragment {
    ArrayList<VerticalRecyclerModel> vertical_layout_models;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.day_vertical_item, container, false);

        RecyclerView recycler_view = view.findViewById(R.id.vertical_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recycler_view.setAdapter(new VerticalRecyclerAdapter(this.getActivity(), getAllDays()));

        return view;
    }

    private ArrayList<VerticalRecyclerModel> getAllDays() {

        int actual_year = Calendar.getInstance().get(Calendar.YEAR);


        Calendar c = new GregorianCalendar(actual_year, Calendar.JUNE, 1);

        SimpleDateFormat m_format = new SimpleDateFormat(" d  EEEE", Locale.getDefault());

        int max_month_days = c.getActualMaximum(Calendar.DAY_OF_MONTH);

        ArrayList<String> all_days = new ArrayList<>();

        for (int i = 0; i < max_month_days; i++) {
            all_days.add(m_format.format(c.getTime()));
            c.add(Calendar.DAY_OF_MONTH, 1);
        }
        /* Add item item name as string to a vertical model position*/

        vertical_layout_models = new ArrayList<>();

        for (int i = 0; i < max_month_days; i++) {
            VerticalRecyclerModel v_model = new VerticalRecyclerModel(all_days.get(i));
            vertical_layout_models.add(v_model);
        }
        return vertical_layout_models;
    }
}
