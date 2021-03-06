package kr.co.snack655.myportfolio.view.activity

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import kr.co.snack655.domain.entitiy.MainBanner
import kr.co.snack655.domain.entitiy.MainBook
import kr.co.snack655.myportfolio.R
import kr.co.snack655.myportfolio.adapter.MainBannerAdapter
import kr.co.snack655.myportfolio.adapter.MainBookAdapter
import kr.co.snack655.myportfolio.base.BaseActivity
import kr.co.snack655.myportfolio.databinding.ActivityMainBinding
import kr.co.snack655.myportfolio.view.fragment.LocationFragment
import kr.co.snack655.myportfolio.viewmodel.activity.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()

    override fun observerViewModel() {
        initMainBookRecycler()
        initMainBannerViewPager()
        initViewSize()
        initLocation()

        with(viewModel) {
            onDetailAddressEvent.observe(this@MainActivity, {
                var state = mBinding.slidingLayout.panelState

                // 닫힌 상태
                if (state == SlidingUpPanelLayout.PanelState.COLLAPSED) {
                    mBinding.slidingLayout.panelState = SlidingUpPanelLayout.PanelState.ANCHORED
                } else if (state == SlidingUpPanelLayout.PanelState.EXPANDED) {
                    mBinding.slidingLayout.panelState = SlidingUpPanelLayout.PanelState.COLLAPSED
                }
            })

            onHomeEvent.observe(this@MainActivity, {
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                intent.putExtra("division", division.value)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_right)
            })
        }
    }

    private fun initMainBookRecycler() {
        val mainBook = ArrayList<MainBook>()
        mainBook.apply {
            add(MainBook("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jp"))
            add(MainBook("https://www.kyongbuk.co.kr/news/photo/201608/967889_245925_3417.jp"))
            add(MainBook("http://m.yummygarden.co.kr/file_data/yummygarden2/2017/08/29/85f725e2e2c4b8ca1890eaf0ee3cadad.jp"))
            add(MainBook("https://www.koreatimes.net/images/attach/121128/20190808-13083162.jp"))
            add(MainBook("https://www.drdic.kr/wp-content/uploads/2018/10/mango.jp"))
            add(MainBook("https://www.sonohotelsresorts.com/img/saupjang/cs/images/travel/ex4_2.jp"))
            add(MainBook("http://www.newsfarm.co.kr/news/photo/202002/53212_33458_5923.jp"))
            add(MainBook("http://cdn.ggilbo.com/news/photo/201905/670907_514704_5449.jp"))
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
            add(MainBanner("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jp"))
            add(MainBanner("https://www.kyongbuk.co.kr/news/photo/201608/967889_245925_3417.jp"))
            add(MainBanner("http://m.yummygarden.co.kr/file_data/yummygarden2/2017/08/29/85f725e2e2c4b8ca1890eaf0ee3cadad.pg"))
            add(MainBanner("https://www.koreatimes.net/images/attach/121128/20190808-13083162.jp"))
            add(MainBanner("https://www.drdic.kr/wp-content/uploads/2018/10/mango.jp"))
            add(MainBanner("https://www.sonohotelsresorts.com/img/saupjang/cs/images/travel/ex4_2.jp"))
            add(MainBanner("http://www.newsfarm.co.kr/news/photo/202002/53212_33458_5923.jp"))
            add(MainBanner("http://cdn.ggilbo.com/news/photo/201905/670907_514704_5449.jp"))
            add(MainBanner("http://cdn.dtnews24.com/news/photo/202106/706644_307222_3627"))
        }

        val mainBannerAdapter = MainBannerAdapter()
        mBinding.mainBannerViewpager.adapter = mainBannerAdapter
        mainBannerAdapter.submitList(mainBanner) // 아이템 업데이트
        Log.d("TESTTEST", "observerViewModel: $mainBanner")
    }

    // 다양한 크기의 화면에서 뷰가 일정한 비율을 유지할 수 있도록 조작하는 함수
    private fun initViewSize() {
        mBinding.btnIntroduce.viewTreeObserver.addOnGlobalLayoutListener {
            val btnIntroWidth = mBinding.btnIntroduce.width
            mBinding.btnIntroduce.layoutParams.height = btnIntroWidth
            mBinding.btnProject.layoutParams.height = btnIntroWidth
            mBinding.btnIntroduce.requestLayout()
            mBinding.btnProject.requestLayout()
        }

        mBinding.btnTech.viewTreeObserver.addOnGlobalLayoutListener {
            val btnTechWidth = (mBinding.btnTech.width) / 2 + 20
            mBinding.btnTech.layoutParams.height = btnTechWidth
            mBinding.btnConnect.layoutParams.height = btnTechWidth
            mBinding.btnOperate.layoutParams.height = btnTechWidth
            mBinding.btnTech.requestLayout()
            mBinding.btnConnect.requestLayout()
            mBinding.btnOperate.requestLayout()
        }
    }

    private fun initLocation() {
        val locationFragment = layoutInflater.inflate(R.layout.fragment_location, null)
        val locationPref = getSharedPreferences("location_prefs", Context.MODE_PRIVATE)
        when(locationPref.getInt("address", 0)) {
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
                val myLocation: TextView = locationFragment.findViewById(R.id.tv_address_home)
                mBinding.tvAddress.text = myLocation.text
            }
            4 -> {
                val myLocation: TextView = locationFragment.findViewById(R.id.tv_address_school)
                mBinding.tvAddress.text = myLocation.text
            }
        }
    }
}