package kr.co.snack655.myportfolio.viewmodel.activity

import kr.co.snack655.myportfolio.base.BaseViewModel
import kr.co.snack655.myportfolio.util.SingleLiveEvent

class HomeViewModel: BaseViewModel() {
    val onDetailAddressEvent = SingleLiveEvent<Unit>()
    val onBackMainEvent = SingleLiveEvent<Unit>()

    fun onClickDetailAddress() {
        onDetailAddressEvent.call()
    }

    fun onClickBackMain() {
        onBackMainEvent.call()
    }
}