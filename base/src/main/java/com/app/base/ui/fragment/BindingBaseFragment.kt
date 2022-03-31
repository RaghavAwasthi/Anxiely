package com.app.base.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding


abstract class BindingBaseFragment<B : ViewBinding> : BaseFragment() {
    lateinit var binding: B

    abstract fun getViewBinding(): B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding()
        onCreateView(binding)
        return binding.root
    }

    abstract fun onCreateView(binding: B)


}