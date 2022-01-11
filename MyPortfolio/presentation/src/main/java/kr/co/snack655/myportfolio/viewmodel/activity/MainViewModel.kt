package kr.co.snack655.myportfolio.viewmodel.activity

import kr.co.snack655.myportfolio.base.BaseViewModel
import kr.co.snack655.myportfolio.util.SingleLiveEvent

class MainViewModel: BaseViewModel() {
    val onDetailAddressEvent = SingleLiveEvent<Unit>()

    fun onClickDetailAddress() {
        onDetailAddressEvent.call()
    }

}