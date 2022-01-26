package kr.co.snack655.myportfolio.view.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import kr.co.snack655.myportfolio.base.BaseFragment
import kr.co.snack655.myportfolio.databinding.FragmentTechBinding
import kr.co.snack655.myportfolio.viewmodel.fragment.TechViewModel

class TechFragment(): BaseFragment<FragmentTechBinding, TechViewModel>() {
    override val viewModel: TechViewModel by viewModels()

    override fun observerViewModel() {
        with(viewModel) {

        }
    }
}