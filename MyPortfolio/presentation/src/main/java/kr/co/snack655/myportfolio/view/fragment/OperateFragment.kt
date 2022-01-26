package kr.co.snack655.myportfolio.view.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import kr.co.snack655.myportfolio.base.BaseFragment
import kr.co.snack655.myportfolio.databinding.FragmentOperateBinding
import kr.co.snack655.myportfolio.viewmodel.fragment.OperateViewModel

class OperateFragment(): BaseFragment<FragmentOperateBinding, OperateViewModel>() {
    override val viewModel: OperateViewModel by viewModels()

    override fun observerViewModel() {
        with(viewModel) {

        }
    }
}