package com.inviscidlabs.behancer.network

import com.inviscidlabs.behancer.model.FieldResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface BehanceService{

@GET( "v2/fields")
fun creativeField(@Query("api_key") api_key: String): Call<FieldResponse>




}
