package com.turo.turo_architecture.businesses

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.turo.turo_architecture.R
import com.turo.turo_architecture.common.BaseActivity
import javax.inject.Inject

class BusinessesActivity : BaseActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: BusinessesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_businesses)

        viewModel = initViewModel()

    }

    private fun initViewModel() = ViewModelProviders
            .of(this, viewModelFactory)
            .get(BusinessesViewModel::class.java)

}
