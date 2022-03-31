package com.app.base.ui.fragment

import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.app.base.ui.BaseViewModel

import java.lang.reflect.ParameterizedType


abstract class VMBindingBaseFragment<VM : BaseViewModel, B : ViewBinding> : BindingBaseFragment<B>() {
    lateinit var viewModel: VM
    open var useSharedViewModel: Boolean = false
    abstract fun onCreateView(binding: B, viewModel: VM)
    override fun onCreateView(binding: B) {
        viewModel = if (useSharedViewModel) {
            ViewModelProvider(requireActivity()).get(getViewModelClass())
        } else {
            ViewModelProvider(this).get(getViewModelClass())
        }
        onCreateView(binding, viewModel)
    }

    private fun getViewModelClass(): Class<VM> {
        val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return type as Class<VM>
    }
}