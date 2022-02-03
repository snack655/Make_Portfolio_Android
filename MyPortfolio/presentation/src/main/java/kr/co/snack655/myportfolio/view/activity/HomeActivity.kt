package kr.co.snack655.myportfolio.view.activity

import android.content.Context
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import kr.co.snack655.myportfolio.R
import kr.co.snack655.myportfolio.adapter.HomeViewpagerAdapter
import kr.co.snack655.myportfolio.base.BaseActivity
import kr.co.snack655.myportfolio.databinding.ActivityHomeBinding
import kr.co.snack655.myportfolio.viewmodel.activity.HomeViewModel

class HomeActivity() : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()

    override fun observerViewModel() {
        initLocation()

        // 1. 소개, 2. 과제, 3. 기술, 4. 연락하기, 5. 운영
        val division: Int = intent.getIntExtra("division", 1)
        Toast.makeText(this, "$division", Toast.LENGTH_SHORT).show()

        with(viewModel) {
            val homeViewPager: ViewPager2 = mBinding.homeViewpager
            val homeTabLayout: TabLayout = mBinding.homeTab

            val homeViewPagerAdapter = HomeViewpagerAdapter(this@HomeActivity)
            homeViewPager.adapter = homeViewPagerAdapter

            val homeTabTitles = listOf<String>("   소개   ", "   과제   ", "   기술   ", "   연락하기   ", "   운영   ")

            homeViewPager.currentItem = division - 1

            TabLayoutMediator(homeTabLayout, homeViewPager) { tab, position ->
                tab.text = homeTabTitles[position]
            }.attach()

            onDetailAddressEvent.observe(this@HomeActivity) {
                var state = mBinding.slidingLayout.panelState

                // 닫힌 상태
                if (state == SlidingUpPanelLayout.PanelState.COLLAPSED) {
                    mBinding.slidingLayout.panelState = SlidingUpPanelLayout.PanelState.ANCHORED
                } else if (state == SlidingUpPanelLayout.PanelState.EXPANDED) {
                    mBinding.slidingLayout.panelState = SlidingUpPanelLayout.PanelState.COLLAPSED
                }
            }

            onBackMainEvent.observe(this@HomeActivity) {
                finish()
            }
        }
    }

    private fun initLocation() {
        val locationFragment = layoutInflater.inflate(R.layout.fragment_location, null)
        val locationPref = getSharedPreferences("location_prefs", Context.MODE_PRIVATE)
        when (locationPref.getInt("address", 0)) {
            0 -> mBinding.tvAddress.text = "위치를 지정해주시오!"
            1 -> {
                val myLocation: TextView = locationFragment.findViewById(R.id.tv_home)
                mBinding.tvAddress.text = myLocation.text
            }
            2 -> {
                val myLocation: TextView = locationFragment.findViewById(R.id.tv_school)
                mBinding.tvAddress.text = myLocation.text
            }
            3 -> {
                val myLocation: TextView =
                    locationFragment.findViewById(R.id.tv_address_home)
                mBinding.tvAddress.text = myLocation.text
            }
            4 -> {
                val myLocation: TextView =
                    locationFragment.findViewById(R.id.tv_address_school)
                mBinding.tvAddress.text = myLocation.text
            }
        }
    }
}