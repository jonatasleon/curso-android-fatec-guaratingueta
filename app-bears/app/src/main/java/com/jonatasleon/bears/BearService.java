package com.jonatasleon.bears;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jonatasleon on 25/06/16.
 */
public interface BearService {

    @GET("bears/")
    Call<List<Bear>> listBears();
}
