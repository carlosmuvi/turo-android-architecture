package com.turo.turo_architecture.di

import com.turo.turo_architecture.App
import com.turo.turo_architecture.businesses.BusinessesBuilder

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ViewModelBuilder::class,
    BusinessesBuilder::class,
    AppModule::class
])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}