package com.example.a3monthhomework4;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SecondFragment extends Fragment {
    ImageView imageView;
    TextView textView,textView2;
    public SecondFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.tv_capit);
        textView2= view.findViewById(R.id.tv_count);
        imageView = view.findViewById(R.id.iv_flag2);

        Bundle bundle = this.getArguments();
        String myCapital = bundle.getString("key");
        String myCountry = bundle.getString("keyy");
        String myImage = bundle.getString("extra");
        imageView.setImageURI(Uri.parse(myImage));
        textView.setText(myCapital);
        textView2.setText(myCountry);
        Picasso.get().load(myImage).into(imageView);
    }
}