package com.mahmoud.mohammed.movieapp

import android.content.Context

class RemoteDataSourceMock private constructor(context: Context) {
    private var willSuccess: Boolean = true
    fun setSuccess(success: Boolean) {
        this.willSuccess = success
    }


    companion object {
        private var INSTANCE: RemoteDataSourceMock? = null

        fun getInstance(context: Context): RemoteDataSourceMock {
            if (INSTANCE == null)
                INSTANCE = RemoteDataSourceMock(context)
            return INSTANCE!!
        }
    }

}