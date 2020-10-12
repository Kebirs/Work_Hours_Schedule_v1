package com.example.workhours.Recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workhours.R;

import java.util.ArrayList;

public class VerticalRecyclerAdapter extends RecyclerView.Adapter<VerticalRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<VerticalRecyclerModel> vertical_layout_items_list;

    public VerticalRecyclerAdapter(Context context, ArrayList<VerticalRecyclerModel> vertical_layout_items_list) {
        this.context = context;
        this.vertical_layout_items_list = vertical_layout_items_list;
    }

    // HOLDER INIT
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.day_item_raw, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.text_view.setText(vertical_layout_items_list.get(position).get_days_name());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.spinner_items,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        holder.hour_items_spinner.setAdapter(adapter);

        holder.hour_items_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // SET TEXT VIEW NEXT TO SPINNER BY SELECTED ITEM
                holder.hour_select_text_view.setText(holder.hour_items_spinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return vertical_layout_items_list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Variable init
        TextView text_view;
        TextView hour_select_text_view;
        Spinner hour_items_spinner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Assign variable
            text_view = itemView.findViewById(R.id.day_item_text_view);
            hour_select_text_view = itemView.findViewById(R.id.spinner_items_view);
            hour_items_spinner = itemView.findViewById(R.id.v_spinner);
        }
    }
}
