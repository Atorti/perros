package com.example.perros.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.perros.Model.Networking.ApiService;
import com.example.perros.Model.Networking.Apiclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositorio {

    private ApiService apiService;
    private MutableLiveData<List<String>> mutablelista = new MutableLiveData<>();

    public Repositorio() {

        apiService = Apiclient.getretro().create(ApiService.class);

    }

    public LiveData<List<String>> listarazas(){

        Call<ListadoPerros> listadoPerrosCall = apiService.getlistadoperros();
        listadoPerrosCall.enqueue(new Callback<ListadoPerros>() {
            @Override
            public void onResponse(Call<ListadoPerros> call, Response<ListadoPerros> response) {
                mutablelista.setValue(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<ListadoPerros> call, Throwable t) {

            }
        });

        return mutablelista;
    }


}
