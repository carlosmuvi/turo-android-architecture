package com.turo.turo_architecture.businesses

import android.arch.lifecycle.ViewModel
import com.turo.turo_architecture.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class BusinessesBuilder {
    @ContributesAndroidInjector(modules = [
        BusinessesModule::class
    ])
    internal abstract fun businessActivity(): BusinessesActivity

    @Binds
    @IntoMap
    @ViewModelKey(BusinessesViewModel::class)
    abstract fun bindViewModel(viewModel: BusinessesViewModel): ViewModel
}