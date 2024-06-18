package com.example.weatherlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WeatherListAdapter extends BaseAdapter {
    private Context context;
    private List<WeatherItem> weatherItems;

    public WeatherListAdapter(Context context, List<WeatherItem> weatherItems) {
        this.context = context;
        this.weatherItems = weatherItems;
    }

    @Override
    public int getCount() {
        return weatherItems.size();
    }

    @Override
    public Object getItem(int position) {
        return weatherItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_item_weather_listview, parent, false);
        }
        ImageView imgWeather = convertView.findViewById(R.id.imgWeather);
        TextView tvCity = convertView.findViewById(R.id.tvCity);
        TextView tvStatus = convertView.findViewById(R.id.tvStatus);
        TextView tvDegree = convertView.findViewById(R.id.tvDegree);

        WeatherItem weatherItem = weatherItems.get(position);

        imgWeather.setImageResource(weatherItem.getImage());
        tvCity.setText(weatherItem.getCity());
        tvStatus.setText(weatherItem.getStatus());
        tvDegree.setText(weatherItem.getDegree() + "°C");

        return convertView;
    }
}


