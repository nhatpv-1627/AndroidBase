package com.vannhat.androidbase.ui.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.vannhat.androidbase.BR
import com.vannhat.androidbase.ui.base.utils.observeInLifecycle
import com.vannhat.androidbase.utils.ext.handleError
import com.vannhat.androidbase.utils.ext.hideSoftKeyBoard
import com.vannhat.androidbase.utils.ext.showErrorMessage
import kotlinx.coroutines.flow.onEach

abstract class BaseFragment<B : ViewDataBinding, V : BaseViewModel> : Fragment() {
    abstract val viewModel: V

    @get:LayoutRes
    abstract val layoutId: Int

    lateinit var binding: B

    protected var baseActivity: BaseActivity<*>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        baseActivity = requireActivity() as? BaseActivity<*>
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            setVariable(BR.viewModel, viewModel)
            executePendingBindings()
            lifecycleOwner = this@BaseFragment.viewLifecycleOwner
        }
        viewModel.eventsFlow.onEach { event ->
            when (event) {
                is BaseViewModel.Event.OnLoading -> showLoading(event.isShowing)
                is BaseViewModel.Event.OnError -> handleError(event.exception)
            }
        }.observeInLifecycle(viewLifecycleOwner)
    }

    open fun handleError(exception: Exception) {
        baseActivity?.handleError(exception)
    }

    open fun showLoading(isLoading: Boolean) {}

    open fun showErrorMessage(message: String) {
        baseActivity?.showErrorMessage(message)
    }

    override fun onDestroyView() {
        binding.root.hideSoftKeyBoard()
        super.onDestroyView()
    }
}
