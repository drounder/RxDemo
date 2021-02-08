package com.yashank.rxdemo

import android.icu.text.NumberingSystem
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlin.math.log


class MainActivity : AppCompatActivity() {

    val stringList = listOf<String>("Delhi","Pune","Bhopal","jaipur","Chandigardh")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val compositeDisposable = CompositeDisposable()
        val ob = Observable.just(stringList)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                for (getValue in it) {
                    Log.d("MainssssActivity", "Show value Value---: $getValue")
                }
            }
        compositeDisposable.add(ob)
    }
}