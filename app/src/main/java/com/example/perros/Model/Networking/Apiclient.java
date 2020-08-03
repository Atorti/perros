package com.example.perros.Model.Networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient {

    public static final String Urlbase = "http://dog.ceo/api/";
    private static Retrofit retro = null;

    public static Retrofit getretro(){
        if (retro == null){
            retro = new Retrofit.Builder()
                    .baseUrl(Urlbase)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return (retro);
    }

}
