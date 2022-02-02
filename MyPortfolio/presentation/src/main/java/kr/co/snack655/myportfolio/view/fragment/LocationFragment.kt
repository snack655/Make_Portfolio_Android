package kr.co.snack655.myportfolio.view.fragment

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import kr.co.snack655.myportfolio.base.BaseFragment
import kr.co.snack655.myportfolio.databinding.FragmentLocationBinding
import kr.co.snack655.myportfolio.view.activity.MainActivity
import kr.co.snack655.myportfolio.viewmodel.fragment.LocationViewModel

class LocationFragment(): BaseFragment<FragmentLocationBinding, LocationViewModel>() {
    override val viewModel: LocationViewModel by viewModels()

    override fun observerViewModel() {
        // 1. 우리집 2. 학교 3. 죽곡푸르지오 1단지 4. 대소고
        val locationPref = activity?.getSharedPreferences("location_prefs", Context.MODE_PRIVATE)
        locationPref?.getInt("address", 0)?.let { onCheckVisibility(it) }

        with(viewModel) {
            division.observe(this@LocationFragment, {
                locationPref?.edit()?.run {
                    putInt("address", it)
                    commit()
                }
                onCheckVisibility(it)
            })
        }
    }

    private fun onCheckVisibility(division: Int) {
        mBinding.ivHomeCheck.visibility = View.INVISIBLE
        mBinding.ivSchoolCheck.visibility = View.INVISIBLE
        mBinding.ivDetailHomeCheck.visibility = View.INVISIBLE
        mBinding.ivDetailSchoolCheck.visibility = View.INVISIBLE
        when(division) {
            1 -> mBinding.ivHomeCheck.visibility = View.VISIBLE
            2 -> mBinding.ivSchoolCheck.visibility = View.VISIBLE
            3 -> mBinding.ivDetailHomeCheck.visibility = View.VISIBLE
            4 -> mBinding.ivDetailSchoolCheck.visibility = View.VISIBLE
        }
    }
}

