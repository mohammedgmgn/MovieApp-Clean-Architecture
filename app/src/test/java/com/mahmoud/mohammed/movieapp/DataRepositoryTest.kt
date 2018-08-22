package com.mahmoud.mohammed.movieapp

import android.content.Context
import android.webkit.ValueCallback
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import javax.inject.Inject

class DataRepositoryTest {
    private val context=mock(Context::class.java)
    private val mMockedRemoteDataSource = RemoteDataSourceMock.getInstance(context)
    private lateinit var mDateDataUnderTesting: RemoteDataSource
    @Mock
    @Inject
    var remoteDataRepository: RemoteDataRepository? = null
    @Mock
    @Inject
    val movieSrvice: MoviesService? = null

    @Before
    fun initRepoUnderTesting() {
        remoteDataRepository= RemoteDataRepository(movieSrvice!!)
       // mDateDataUnderTesting =  RemoteDataRepository(mMockedRemoteDataSource)
    }

    @Test
    fun getMoviesSuccess() {
        mMockedRemoteDataSource.setSuccess(true)
        remoteDataRepository!!.getMovieList(1, ValueCallback {
            assert(it)
        })
    }


}