package kr.co.snack655.myportfolio.view.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import kr.co.snack655.myportfolio.base.BaseFragment
import kr.co.snack655.myportfolio.databinding.FragmentIntroBinding
import kr.co.snack655.myportfolio.viewmodel.fragment.IntroViewModel

class IntroFragment(): BaseFragment<FragmentIntroBinding, IntroViewModel>() {
    override val viewModel: IntroViewModel by viewModels()

    override fun observerViewModel() {
        with(viewModel) {

        }
        Toast.makeText(context, "소환!", Toast.LENGTH_SHORT).show()
    }
}