package com.sardavisgeekbrains.librariessd

class CountersPresenter(private val view: MainView) {

    val model = CountersModel()

    fun onCounterOneClick(){
        val newValue = model.next(0)
        view.setCounterOne(newValue.toString())
    }

    fun onCounterTwoClick(){
        val newValue = model.next(1)
        view.setCounterTwo(newValue.toString())
    }

    fun onCounterThreeClick(){
        val newValue = model.next(2)
        view.setCounterThree(newValue.toString())
    }

}
