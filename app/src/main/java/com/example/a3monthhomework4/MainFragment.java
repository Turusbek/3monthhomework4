package com.example.a3monthhomework4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MainFragment extends Fragment implements OnItemClick{
    private RecyclerView recyclerView;
    private ArrayList<Country> countries = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_country);
        countries.add(new Country("Kyrgyzstan","Bishkek","https://upload.wikimedia.org/wikipedia/commons/b/ba/Flag_of_Kyrgyzstan.png"));
        countries.add(new Country("Uzbekistan","Tashkent","https://seeklogo.com/images/F/flag-of-uzbekistan-logo-2997C4B4A2-seeklogo.com.png"));
        countries.add(new Country("Kazakhstan","Astana","https://w7.pngwing.com/pngs/152/883/png-transparent-flag-of-kazakhstan-flags-of-asia-flags-of-the-world-flag-miscellaneous-flag-text.png"));
        countries.add(new Country("Ukraine","Kiev","https://toppng.com/uploads/preview/ukraine-large-flag-11547886040xevtjjr9bj.png"));
        countries.add(new Country("Turkey","Istanbul","https://upload.wikimedia.org/wikipedia/commons/8/87/Flag_of_Turkey.png"));
        countries.add(new Country("Russia","Moscow","https://upload.wikimedia.org/wikipedia/commons/d/d4/Flag_of_Russia.png"));
        countries.add(new Country("Usa","Washington","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/US_flag_large_51_stars.png/1024px-US_flag_large_51_stars.png"));
        countries.add(new Country("Germany","Berlin","https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Flag_of_Germany.svg/800px-Flag_of_Germany.svg.png?20070926182838"));
        countries.add(new Country("Poland","Warsaw","https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/Flag_of_Poland.svg/2560px-Flag_of_Poland.svg.png"));
        countries.add(new Country("Mexico","Mexico city","https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Flag_of_Mexico.png/1280px-Flag_of_Mexico.png"));
        countries.add(new Country("Egypt","Cairo","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Flag_of_Egypt_%28variant%29.png/1200px-Flag_of_Egypt_%28variant%29.png"));
        countries.add(new Country("Korea","Seul","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Flag_of_South_Korea.png/1024px-Flag_of_South_Korea.png"));
        countries.add(new Country("China","Beijing","https://w7.pngwing.com/pngs/221/273/png-transparent-flag-of-china-chinese-communist-revolution-symbol-chinese-flag-border-miscellaneous-floating-thumbnail.png"));
        countries.add(new Country("Japan","Tokyo","https://upload.wikimedia.org/wikipedia/commons/a/af/Flag_of_Japan_bordered.png"));
        countries.add(new Country("French","Paris","https://www.pngall.com/wp-content/uploads/2016/06/France-Flag-PNG-Image.png"));
        CountryAdapter adapter = new CountryAdapter(countries, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(Country country) {
        Bundle bundle = new Bundle();
        String myText = country.getCapital();
        String myName = country.getName();
        String myImage = country.getFlag();
        bundle.putString("key",myText);
        bundle.putString("extra",myImage);
        bundle.putString("keyy",myName);
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contayner,
                secondFragment).commit();

    }
}