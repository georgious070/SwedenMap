package com.example.android.swedenmap.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.swedenmap.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private final List<String> cityList;
    private OnCityClickListener cityClickListener;

    public CityAdapter(OnCityClickListener cityClickListener) {
        this.cityList = new ArrayList<>();
        this.cityClickListener = cityClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.city_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cityClickListener.onClickCity(cityList);
            }
        });
        holder.cityName.setText(cityList.get(position));
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public void setData(List<String> cityList) {
        this.cityList.clear();
        this.cityList.addAll(cityList);
        notifyDataSetChanged();
    }

    public interface OnCityClickListener {

        void onClickCity(List<String> cities);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView cityName;

        ViewHolder(View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.city_name);
        }
    }
}
