package com.inviscidlabs.behancer.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.inviscidlabs.behancer.model.AllFields
import com.inviscidlabs.behancer.model.FieldResponse
import com.inviscidlabs.behancer.model.PopularFields
import com.inviscidlabs.behancer.network.BehanceAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeViewModel: ViewModel(){

    //MutableLiveData
    private val _loading = MutableLiveData<Boolean>()
    private val _allFields = MutableLiveData<List<AllFields>>()
    private val _popularFields = MutableLiveData<List<PopularFields>>()
    private val _loadingErrorFields = MutableLiveData<Boolean>()
    private var fieldResponse: FieldResponse? = null

    //Exposed Livedata
    val loading: LiveData<Boolean> get() = _loading
    val allFields: LiveData<List<AllFields>> get() = _allFields
    val popularFields: LiveData<List<PopularFields>> get() = _popularFields
    val loadingErrorFields: LiveData<Boolean> get() = _loadingErrorFields

    private val fieldCall: Call<FieldResponse>

    private val API_KEY = "nkqEnumvUob0tPavc1nYgG7nWC93afNs"
    init {
        fieldCall = BehanceAPI.behanceService.creativeField(API_KEY)
        Log.e(javaClass.simpleName, BehanceAPI.behanceService.creativeField(API_KEY).request().url().toString())
        loadFields()

    }

    private fun loadFields() {
        _loading.value = true
        fieldCall.enqueue(object: Callback<FieldResponse> {
            override fun onResponse(call: Call<FieldResponse>, response: Response<FieldResponse>) {
                _loadingErrorFields.value=false
                _loading.value=false
                _allFields.value = response?.body()?.fields
                _popularFields.value = response?.body()?.popular
            }
            override fun onFailure(call: Call<FieldResponse>?, t: Throwable?) {
                Log.e(javaClass.simpleName, "Error loading creative allFields:", t)

                _loading.value=false
                _loadingErrorFields.value = true
            }
        })
    }


}