package com.example.a3monthhomework4;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private ArrayList<Country> countries;
    private OnItemClick onItemClick;
    public CountryAdapter(ArrayList<Country> countries,OnItemClick onItemClick) {
        this.countries = countries;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contry,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, @SuppressLint("RecyclerView") int position) {
  holder.bind(countries.get(position));
  holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          onItemClick.onItemClick(countries.get(position));

      }
  });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
   static class CountryViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCountry,tvCapital;
        private ImageView ivFlag;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountry = itemView.findViewById(R.id.tv_country);
            tvCapital = itemView.findViewById(R.id.tv_capital);
            ivFlag = itemView.findViewById(R.id.iv_flag);

        }
        public void bind(Country country){
            tvCountry.setText(country.getName());
            tvCapital.setText(country.getCapital());
            Picasso.get().load(country.getFlag()).into(ivFlag);
        }
    }
}
