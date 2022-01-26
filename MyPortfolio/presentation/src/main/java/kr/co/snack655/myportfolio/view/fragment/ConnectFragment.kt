package kr.co.snack655.myportfolio.view.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import kr.co.snack655.myportfolio.base.BaseFragment
import kr.co.snack655.myportfolio.databinding.FragmentConnectBinding
import kr.co.snack655.myportfolio.viewmodel.fragment.ConnectViewModel

class ConnectFragment(): BaseFragment<FragmentConnectBinding, ConnectViewModel>() {
    override val viewModel: ConnectViewModel by viewModels()

    override fun observerViewModel() {
        with(viewModel) {

        }
    }
}