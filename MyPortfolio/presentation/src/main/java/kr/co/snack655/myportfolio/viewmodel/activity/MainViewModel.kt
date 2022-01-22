package kr.co.snack655.myportfolio.viewmodel.activity

import androidx.lifecycle.MutableLiveData
import kr.co.snack655.myportfolio.base.BaseViewModel
import kr.co.snack655.myportfolio.util.SingleLiveEvent

class MainViewModel: BaseViewModel() {
    val onDetailAddressEvent = SingleLiveEvent<Unit>()
    val onHomeEvent = SingleLiveEvent<Unit>()

    val division = MutableLiveData<Int>()

    fun onClickDetailAddress() {
        onDetailAddressEvent.call()
    }

    fun onClickHome(division: Int) {
        this.division.value = division
        onHomeEvent.call()
    }

}