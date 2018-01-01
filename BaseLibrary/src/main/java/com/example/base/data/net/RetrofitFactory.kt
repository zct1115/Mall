package com.example.base.data.net

import com.example.base.commen.BaseConstant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * RetrofitFactory用于网络请求回调结果
 * Created by zct11 on 2018/1/1.
 */
class RetrofitFactory private constructor(){

    /*单例模式实现初始化采用懒加载*/
    companion object {
        val instance:RetrofitFactory by lazy { RetrofitFactory() }
    }


    private val retrofit:Retrofit
    private val interceptor:Interceptor

    init {
        /*http头部请求拦截器*/
        interceptor= Interceptor {
            chain ->
           val request=chain.request()
                    .newBuilder()
                    .addHeader("Content-Type","application/json")
                    .addHeader("charset","utf-8")
                    .build()
            chain.proceed(request)
        }

        /*retrofit初始化*/
        retrofit=Retrofit.Builder()
                .baseUrl(BaseConstant.SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(initClient())
                .build()
    }
    /**
     * 初始化OkhttpClient
     * addInterceptor增加拦截器
     * connectTimeout连接时间
     * readTimeout运行时间
     */
    private fun initClient(): OkHttpClient{
        return   OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(initLogInterceptor())
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .build()

    }
    /**
     * 显示body级别的日志
     */
    private fun initLogInterceptor(): Interceptor {
       val interceptor=HttpLoggingInterceptor()
        interceptor.level=HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    /**
     * 创建retrofit
     */
    fun <T> create(service:Class<T>):T{
      return retrofit.create(service)
    }
}