package kr.co.snack655.myportfolio.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import kr.co.snack655.myportfolio.base.BaseActivity
import kr.co.snack655.myportfolio.databinding.ActivityHomeBinding
import kr.co.snack655.myportfolio.viewmodel.activity.HomeViewModel

class HomeActivity() : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()

    override fun observerViewModel() {

    }
}