package kr.co.snack655.myportfolio.view.fragment

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import kr.co.snack655.domain.entitiy.HomeIntro
import kr.co.snack655.domain.entitiy.MainBanner
import kr.co.snack655.myportfolio.adapter.HomeIntroAdapter
import kr.co.snack655.myportfolio.adapter.MainBannerAdapter
import kr.co.snack655.myportfolio.base.BaseFragment
import kr.co.snack655.myportfolio.databinding.FragmentIntroBinding
import kr.co.snack655.myportfolio.viewmodel.fragment.IntroViewModel

class IntroFragment(): BaseFragment<FragmentIntroBinding, IntroViewModel>() {
    override val viewModel: IntroViewModel by viewModels()

    override fun observerViewModel() {
        initHomeIntroViewPager()
        with(viewModel) {

        }
    }

    private fun initHomeIntroViewPager() {
        val homeIntro = ArrayList<HomeIntro>()
        homeIntro.apply {
            add(HomeIntro("이거 되냐.."))
            add(HomeIntro("제발"))
            add(HomeIntro("좀"))
            add(HomeIntro("좀"))
            add(HomeIntro("좀"))
            add(HomeIntro("좀"))
            add(HomeIntro("좀"))
            add(HomeIntro("좀"))
            add(HomeIntro("좀"))
            add(HomeIntro("좀"))
            add(HomeIntro("좀"))
        }

        val homeIntroAdapter = HomeIntroAdapter()
        mBinding.homeIntroViewpager.adapter = homeIntroAdapter
        homeIntroAdapter.submitList(homeIntro) // 아이템 업데이트
        // viewPager에 인디케이터 연결하기
        mBinding.dotsIndicator.setViewPager2(mBinding.homeIntroViewpager)
    }
}