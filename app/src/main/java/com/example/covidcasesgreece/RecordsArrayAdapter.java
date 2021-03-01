package com.example.covidcasesgreece;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class RecordsArrayAdapter extends ArrayAdapter<AreaRecord> {

    private List<AreaRecord> recordsList;
    private final LayoutInflater inflater;
    private final int layoutResource;

    private final ListView recordsListView;


    public RecordsArrayAdapter(@NonNull Context context, int resource, @NonNull List<AreaRecord> objects, ListView listView) {
        super(context, resource, objects);
        recordsList = objects;
        layoutResource = resource;
        inflater = LayoutInflater.from(context);
        recordsListView = listView;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){
            convertView = inflater.inflate(layoutResource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
            Log.w("VIEW_HOLDER", "View Holder Created");
        }
        else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        AreaRecord currentRecord = recordsList.get(position);

        viewHolder.areaName.setText(currentRecord.getName());

        viewHolder.dayDiff.setText(currentRecord.getDayDiff()+"");
        if(currentRecord.getDayDiff()>=0)
            viewHolder.dayDiff.setTextColor(Color.GREEN);
        else
            viewHolder.dayDiff.setTextColor(Color.RED);

        viewHolder.dayTotal.setText(currentRecord.getDayTotal()+"");
        viewHolder.totalVacc.setText(currentRecord.getTotalVaccinations()+"");
        viewHolder.totalVacc.setTypeface(null, Typeface.BOLD);

        return convertView;
    }

    private class ViewHolder{
        final TextView areaName;
        final TextView dayDiff;
        final TextView dayTotal;
        final TextView totalVacc;
        final TextView dayDiffTxt;
        final TextView dayTotalTxt;
        final TextView totalVaccTxt;

        ViewHolder(View view){
            areaName = view.findViewById(R.id.areaTextView);
            dayDiff = view.findViewById(R.id.daydiffCount);
            dayTotal = view.findViewById(R.id.dayTotalCount);
            totalVacc = view.findViewById(R.id.totalVaccinationsCount);
            dayDiffTxt = view.findViewById(R.id.daydiffTextView);
            dayTotalTxt = view.findViewById(R.id.dayTotalTextView);
            totalVaccTxt = view.findViewById(R.id.totalVaccinationsTextView);

        }
    }


    @Override
    public int getCount() {
        return recordsList.size();
    }

    public void setRecordsList(List<AreaRecord> recordsList) {
        this.recordsList = recordsList;
        recordsListView.setAdapter(this);
    }
}