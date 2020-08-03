package com.example.perros.Model.Networking;

import com.example.perros.Model.ListadoFotos;
import com.example.perros.Model.ListadoPerros;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("breeds/list/")
    Call<ListadoPerros> getlistadoperros();

    @GET("breed/{razas}/images/")
    Call<ListadoFotos> getlistadofotos(@Path("razas") String razas );


}
