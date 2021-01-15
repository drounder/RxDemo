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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val compositeDisposable = CompositeDisposable()


        val ob = Observable.just(arrayListOf(1..100))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                for(getValue in it){
                    Log.d("MainActivity", "Value---: $getValue")

            }

            }
        compositeDisposable.add(ob)

    }
}