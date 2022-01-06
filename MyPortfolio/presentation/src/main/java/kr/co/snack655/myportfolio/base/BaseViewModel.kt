package kr.co.snack655.myportfolio.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

open class BaseViewModel: ViewModel() {
    private val disposable: CompositeDisposable = CompositeDisposable()

    protected val isLoading = MutableLiveData(false)

    fun getIsLoading(): LiveData<Boolean> = isLoading

    val onErrorEvent = MutableLiveData<Throwable>()

    fun addDisposable(single: Single<*>, observer: DisposableSingleObserver<*>) {
        disposable.add(
            single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer as SingleObserver<Any>) as Disposable
        )
    }

    fun <T> addDisposable(single: Single<T>, onSuccess: (T) -> Unit, onFailure: (Throwable) -> Unit) {
        disposable.add(
            single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(onSuccess, onFailure)
        )
    }

    fun addDisposable(completable: Completable, observer: DisposableCompletableObserver) {
        disposable.add(
            completable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(observer) as Disposable
        )
    }

    fun addDisposable(completable: Completable, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        disposable.add(
            completable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(onSuccess, onFailure)
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}