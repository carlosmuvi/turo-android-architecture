package com.turo.turo_architecture.di

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ProcessLifecycleOwner
import android.content.Context

import com.turo.turo_architecture.App

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    internal fun provideContext(application: App): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        val disposables = CompositeDisposable()
        // Add ProcessLifecycleOwner observer to clear when stopped
        ProcessLifecycleOwner.get().lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            fun onStopped() {
                disposables.clear()
            }
        })
        return disposables
    }
}
