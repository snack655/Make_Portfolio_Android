package kr.co.snack655.myportfolio.view.activity

import android.widget.Toast
import androidx.activity.viewModels
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
            onBackMainEvent.observe(this@HomeActivity, {
                finish()
            })
        }
    }
}