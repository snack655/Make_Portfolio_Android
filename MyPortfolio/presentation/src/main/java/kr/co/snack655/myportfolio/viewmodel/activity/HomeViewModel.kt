package kr.co.snack655.myportfolio.viewmodel.activity

import kr.co.snack655.myportfolio.base.BaseViewModel
import kr.co.snack655.myportfolio.util.SingleLiveEvent

class HomeViewModel: BaseViewModel() {
    val onBackMainEvent = SingleLiveEvent<Unit>()

    fun onClickBackMain() {
        onBackMainEvent.call()
    }
}