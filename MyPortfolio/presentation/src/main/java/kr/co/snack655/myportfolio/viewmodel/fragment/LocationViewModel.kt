package kr.co.snack655.myportfolio.viewmodel.fragment

import androidx.lifecycle.MutableLiveData
import kr.co.snack655.myportfolio.base.BaseViewModel
import kr.co.snack655.myportfolio.util.SingleLiveEvent

class LocationViewModel: BaseViewModel() {
    // 1. 우리집 2. 학교 3. 죽곡푸르지오 1단지 4. 대소고
    val division = MutableLiveData<Int>()

    fun onClickAddress(division: Int) {
        this.division.value = division
    }
}