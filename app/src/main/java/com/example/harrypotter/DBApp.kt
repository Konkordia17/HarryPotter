package com.example.harrypotter

import android.app.Application

class DBApp : Application() {
    override fun onCreate() {
        super.onCreate()
        app = this
        HPDataBase.getInstance(this)
    }

    companion object {
        lateinit var app: DBApp
    }
}