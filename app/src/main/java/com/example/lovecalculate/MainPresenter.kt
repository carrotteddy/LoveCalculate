package com.example.lovecalculate

import android.util.Log
import com.example.lovecalculate.model.LoveApi
import com.example.lovecalculate.model.LoveModel
import com.example.lovecalculate.model.room.LoveDao
import com.example.lovecalculate.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainPresenter @Inject constructor(private val api: LoveApi, private val dao: LoveDao) {


    lateinit var view: MainView


    fun getData(firstName: String, secondName: String) {

        api.getPercentage(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    val model = response.body()
                    model?.let {
                        it.creationDate = System.currentTimeMillis()
                        dao.insert(it)
                        view.changeScreen(it)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("fail", "fail")
            }

        })

    }

    fun attachView(view: MainView) {
        this.view = view
    }

}