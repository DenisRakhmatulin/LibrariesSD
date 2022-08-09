package com.sardavisgeekbrains.librariessd

import moxy.MvpPresenter

class CountersPresenter(private val model : CountersModel) : MvpPresenter<MainView>(){

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun onCounterOneClick(){
        val newValue = model.next(0)
        viewState.setCounterOne(newValue.toString())
    }

    fun onCounterTwoClick(){
        val newValue = model.next(1)
        viewState.setCounterTwo(newValue.toString())
    }

    fun onCounterThreeClick(){
        val newValue = model.next(2)
        viewState.setCounterThree(newValue.toString())
    }

}
