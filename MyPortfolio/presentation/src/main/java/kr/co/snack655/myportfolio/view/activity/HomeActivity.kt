package kr.co.snack655.myportfolio.view.activity

import android.widget.Toast
import androidx.activity.viewModels
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import kr.co.snack655.myportfolio.base.BaseActivity
import kr.co.snack655.myportfolio.databinding.ActivityHomeBinding
import kr.co.snack655.myportfolio.viewmodel.activity.HomeViewModel

class HomeActivity() : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()

    override fun observerViewModel() {
        // 1. 소개, 2. 과제, 3. 기술, 4. 연락하기, 5. 운영
        val division: Int = intent.getIntExtra("division", 1)
        Toast.makeText(this, "$division", Toast.LENGTH_SHORT).show()

        with(viewModel) {
            onDetailAddressEvent.observe(this@HomeActivity, {
                var state = mBinding.slidingLayout.panelState

                // 닫힌 상태
                if (state == SlidingUpPanelLayout.PanelState.COLLAPSED) {
                    mBinding.slidingLayout.panelState = SlidingUpPanelLayout.PanelState.ANCHORED
                } else if (state == SlidingUpPanelLayout.PanelState.EXPANDED) {
                    mBinding.slidingLayout.panelState = SlidingUpPanelLayout.PanelState.COLLAPSED
                }
            })

            onBackMainEvent.observe(this@HomeActivity, {
                finish()
            })
        }
    }
}