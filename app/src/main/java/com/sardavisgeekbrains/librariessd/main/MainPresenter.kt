package com.sardavisgeekbrains.librariessd.main

import com.github.terrakok.cicerone.Router
import com.sardavisgeekbrains.librariessd.core.nav.DetailsScreen
import com.sardavisgeekbrains.librariessd.core.nav.UsersScreen
import moxy.MvpPresenter

class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen)
    }

    fun onBackPressed() {
        router.exit()
    }




}
