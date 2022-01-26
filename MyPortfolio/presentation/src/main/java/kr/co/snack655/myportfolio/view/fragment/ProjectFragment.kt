package kr.co.snack655.myportfolio.view.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import kr.co.snack655.myportfolio.base.BaseFragment
import kr.co.snack655.myportfolio.databinding.FragmentProjectBinding
import kr.co.snack655.myportfolio.viewmodel.fragment.ProjectViewModel

class ProjectFragment(): BaseFragment<FragmentProjectBinding, ProjectViewModel>() {
    override val viewModel: ProjectViewModel by viewModels()

    override fun observerViewModel() {
        with(viewModel) {

        }
    }
}