package com.ajithvgiri.notes.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("todos/")
    Call<List<Notes>> getNotes();

}
