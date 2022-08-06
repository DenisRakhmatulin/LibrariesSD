package com.sardavisgeekbrains.librariessd

class CountersPresenter(private val view: MainView) {

    val model = CountersModel()

    fun onCounterClick(id: Int) {
        when (id) {
            R.id.btnNumber1 -> {
                val newValue = model.next(0)
                view.setText(newValue.toString(), 0)
            }
            R.id.btnNumber2 -> {
                val newValue = model.next(1)
                view.setText(newValue.toString(), 1)
            }
            R.id.btnNumber3 -> {
                val newValue = model.next(2)
                view.setText(newValue.toString(), 2)
            }
        }

    }
}
