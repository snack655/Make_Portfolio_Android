package kr.co.snack655.myportfolio.view

import android.util.Log
import androidx.activity.viewModels
import kr.co.snack655.domain.entitiy.MainBanner
import kr.co.snack655.domain.entitiy.MainBook
import kr.co.snack655.myportfolio.R
import kr.co.snack655.myportfolio.adapter.MainBannerAdapter
import kr.co.snack655.myportfolio.adapter.MainBookAdapter
import kr.co.snack655.myportfolio.base.BaseActivity
import kr.co.snack655.myportfolio.databinding.ActivityMainBinding
import kr.co.snack655.myportfolio.viewmodel.activity.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()

    override fun observerViewModel() {
        initMainBookRecycler()
        initMainBannerViewPager()
    }

    private fun initMainBookRecycler() {
        val mainBook = ArrayList<MainBook>()
        mainBook.apply {
            add(MainBook("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg"))
            add(MainBook("https://www.kyongbuk.co.kr/news/photo/201608/967889_245925_3417.jpg"))
            add(MainBook("http://m.yummygarden.co.kr/file_data/yummygarden2/2017/08/29/85f725e2e2c4b8ca1890eaf0ee3cadad.jpg"))
            add(MainBook("https://www.koreatimes.net/images/attach/121128/20190808-13083162.jpg"))
            add(MainBook("https://www.drdic.kr/wp-content/uploads/2018/10/mango.jpg"))
            add(MainBook("https://www.sonohotelsresorts.com/img/saupjang/cs/images/travel/ex4_2.jpg"))
            add(MainBook("http://www.newsfarm.co.kr/news/photo/202002/53212_33458_5923.jpg"))
            add(MainBook("http://cdn.ggilbo.com/news/photo/201905/670907_514704_5449.jpg"))
            add(MainBook("http://cdn.dtnews24.com/news/photo/202106/706644_307222_3627"))
        }

        val mainBookAdapter = MainBookAdapter()
        mBinding.mainBookRecycler.adapter = mainBookAdapter
        mainBookAdapter.submitList(mainBook) // 아이템 업데이트
        Log.d("TESTTEST", "observerViewModel: $mainBook")
    }

    private fun initMainBannerViewPager() {
        val mainBanner = ArrayList<MainBanner>()
        mainBanner.apply {
            add(MainBanner("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg"))
            add(MainBanner("https://www.kyongbuk.co.kr/news/photo/201608/967889_245925_3417.jpg"))
            add(MainBanner("http://m.yummygarden.co.kr/file_data/yummygarden2/2017/08/29/85f725e2e2c4b8ca1890eaf0ee3cadad.jpg"))
            add(MainBanner("https://www.koreatimes.net/images/attach/121128/20190808-13083162.jpg"))
            add(MainBanner("https://www.drdic.kr/wp-content/uploads/2018/10/mango.jpg"))
            add(MainBanner("https://www.sonohotelsresorts.com/img/saupjang/cs/images/travel/ex4_2.jpg"))
            add(MainBanner("http://www.newsfarm.co.kr/news/photo/202002/53212_33458_5923.jpg"))
            add(MainBanner("http://cdn.ggilbo.com/news/photo/201905/670907_514704_5449.jpg"))
            add(MainBanner("http://cdn.dtnews24.com/news/photo/202106/706644_307222_3627"))
        }

        val mainBannerAdapter = MainBannerAdapter()
        mBinding.mainBannerViewpager.adapter = mainBannerAdapter
        mainBannerAdapter.submitList(mainBanner) // 아이템 업데이트
        Log.d("TESTTEST", "observerViewModel: $mainBanner")
    }
}