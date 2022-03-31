package com.app.base.ui.activity

import android.os.Bundle
import androidx.viewbinding.ViewBinding


abstract class BindingBaseActivity<B : ViewBinding> : BaseActivity() {
    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        onCreate(savedInstanceState, binding)
    }

    protected abstract fun onCreate(savedInstanceState: Bundle?, binding: B)


    abstract fun getViewBinding(): B
}

