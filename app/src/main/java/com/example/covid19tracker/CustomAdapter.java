package com.example.covid19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<Model> {

    private Context context;
    private List<Model> countryList;
    ArrayList<Model> arrayList;

    public CustomAdapter(Context context, List<Model> countryList) {
        super(context, R.layout.custom_list, countryList);

        this.context=context;
        this.countryList=countryList;

        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(countryList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list,null,true);

        TextView country=view.findViewById(R.id.country);
        TextView cases=view.findViewById(R.id.cases);
        TextView todayCases=view.findViewById(R.id.todayCases);
        TextView recovered=view.findViewById(R.id.recovered);
        TextView todayRecovered=view.findViewById(R.id.todayRecovered);
        TextView deaths=view.findViewById(R.id.deaths);
        TextView todayDeaths=view.findViewById(R.id.todayDeaths);


        country.setText(countryList.get(position).getCountry());
        cases.setText(countryList.get(position).getCases());
        todayCases.setText("+ "+countryList.get(position).getTodayCases());
        recovered.setText(countryList.get(position).getRecovered());
        todayRecovered.setText("+ "+countryList.get(position).getTodayRecovered());
        deaths.setText(countryList.get(position).getDeaths());
        todayDeaths.setText("+ "+countryList.get(position).getTodayDeaths());

        return view;
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Nullable
    @Override
    public Model getItem(int position) {
        return countryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        countryList.clear();

            for (Model model : arrayList){
                if (model.getCountry().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    countryList.add(model);
                }
            }

        notifyDataSetChanged();
    }
}
