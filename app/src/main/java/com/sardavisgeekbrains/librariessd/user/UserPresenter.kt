package com.sardavisgeekbrains.librariessd.user

import com.github.terrakok.cicerone.Router
import com.sardavisgeekbrains.librariessd.main.MainView
import com.sardavisgeekbrains.librariessd.repository.GithubRepository
import moxy.MvpPresenter

class UserPresenter(private val repository: GithubRepository, private val router: Router) : MvpPresenter<UserView>(){

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

    fun onBackPressed() : Boolean {
        router.exit()
        return true
    }

}