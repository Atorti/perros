package com.example.perros;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.perros.Model.ListadoPerros;
import com.example.perros.Model.Networking.ApiService;
import com.example.perros.Model.Networking.Apiclient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        ApiService apiService = Apiclient.getretro().create(ApiService.class);

        Call<ListadoPerros> call = apiService.getlistadoperros();

        call.enqueue(new Callback<ListadoPerros>() {
            @Override
            public void onResponse(Call<ListadoPerros> call, Response<ListadoPerros> response) {
                Log.d("respuesta", String.valueOf(response.body().getMessage()));
            }

            @Override
            public void onFailure(Call<ListadoPerros> call, Throwable t) {
                Log.d("errorrespuesta", t.getMessage());
            }
        });


    }
}