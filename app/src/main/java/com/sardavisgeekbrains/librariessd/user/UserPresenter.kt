package com.sardavisgeekbrains.librariessd.user

import android.util.Log
import com.github.terrakok.cicerone.Router
import com.sardavisgeekbrains.librariessd.core.nav.DetailsScreen
import com.sardavisgeekbrains.librariessd.repository.GithubRepository
import moxy.MvpPresenter

class UserPresenter(private val repository: GithubRepository, private val router: Router) :
    MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
        repository.getUsers()
            .subscribe({
                viewState.initList(it)
                viewState.hideLoading()
            }, {
            })
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    fun setDetailsFragment(login: String) {
        router.navigateTo(DetailsScreen(login))
    }

}