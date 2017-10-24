package com.example.android.swedenmap.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.swedenmap.R;

import org.w3c.dom.Text;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private List<String> cityList;

    public void setData(List<String> cityList){
        this.cityList.clear();
        this.cityList.addAll(cityList);
        notifyDataSetChanged();
    }

    public CityAdapter(List<String> cityList){
        this.cityList = cityList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView cityName;

        public ViewHolder(View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.city_name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.city_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cityName.setText(cityList.get(position));
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }
}
