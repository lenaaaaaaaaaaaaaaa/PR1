package ru.mirea.nadezhkinaea.mireaproject.ui.lesson8;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mirea.nadezhkinaea.mireaproject.R;
import ru.mirea.nadezhkinaea.mireaproject.databinding.FragmentMapBinding;

public class MapFragment extends Fragment {
    private FragmentMapBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMapBinding.inflate(inflater, container, false);

        setButtons();

        return binding.getRoot();
    }

    private void setButtons() {
        binding.buttonShow1.setOnClickListener(v -> startMapActivity(
                "Большой театр",
                "Театральная площадь, 1, Москва",
                55.760257, 37.618536));

        binding.buttonShow2.setOnClickListener(v -> startMapActivity(
                "Found Record Store & Pizzeria",
                "Цветной бул., 15, стр. 1, Москва",
                55.771083, 37.620714));

        binding.buttonShow3.setOnClickListener(v -> startMapActivity(
                "Парк Новодевичьи Пруды",
                "Новодевичий пр., 1, Москва",
                55.727782, 37.554060));

        binding.buttonShow4.setOnClickListener(v -> startMapActivity(
                "Сбербанк России" ,
                "2-й Южнопортовый пр., 12А, корп. 1, стр. 1, Москва",
                55.701780, 37.689276));
    }

    private void startMapActivity(String title, String description, double latitude, double longitude) {
        Intent intent = new Intent(getActivity(), MapActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("description", description);
        intent.putExtra("latitude", latitude);
        intent.putExtra("longitude", longitude);
        startActivity(intent);
    }
}
