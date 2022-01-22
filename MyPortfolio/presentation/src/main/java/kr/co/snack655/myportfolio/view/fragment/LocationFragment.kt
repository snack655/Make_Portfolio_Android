package kr.co.snack655.myportfolio.view.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import kr.co.snack655.myportfolio.base.BaseFragment
import kr.co.snack655.myportfolio.databinding.FragmentLocationBinding
import kr.co.snack655.myportfolio.viewmodel.fragment.LocationViewModel

class LocationFragment(): BaseFragment<FragmentLocationBinding, LocationViewModel>() {
    override val viewModel: LocationViewModel by viewModels()

    override fun observerViewModel() {
        with(viewModel) {

        }
        Toast.makeText(context, "소환!", Toast.LENGTH_SHORT).show()
    }
}