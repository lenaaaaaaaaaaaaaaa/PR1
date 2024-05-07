package ru.mirea.nadezhkinaea.mireaproject.ui.lesson6;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mirea.nadezhkinaea.mireaproject.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    private SharedPreferences sharedPreferences;
    private FragmentProfileBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);

        setSharedPreferences();

        fillFields();

        return binding.getRoot();
    }

    private void setSharedPreferences() {
        binding.buttonSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getActivity().getSharedPreferences("profile_settings",
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("ДАТА", binding.editTextData.getText().toString());
                editor.putString("РОСТ", binding.editTextH.getText().toString());
                editor.putString("ВЕС", binding.editTextW.getText().toString());
                editor.putString("ОЩУЩЕНИЯ", binding.editTextTHOUGHTS.getText().toString());

                editor.apply();
            }
        });
    }

    private void fillFields() {
        sharedPreferences = getActivity().getSharedPreferences("profile_settings",
                Context.MODE_PRIVATE);

        binding.editTextData.setText(sharedPreferences.getString("ДАТА", ""));
        binding.editTextH.setText(sharedPreferences.getString("РОСТ", ""));
        binding.editTextW.setText(sharedPreferences
                .getString("ВЕС", ""));
        binding.editTextTHOUGHTS.setText(sharedPreferences.getString("ОЩУЩЕНИЯ", ""));
    }
}
