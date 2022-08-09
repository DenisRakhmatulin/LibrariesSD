package com.sardavisgeekbrains.librariessd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sardavisgeekbrains.librariessd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        with(binding) {
            btnNumber1.setOnClickListener {
                presenter.onCounterOneClick()
            }
            btnNumber2.setOnClickListener {
                presenter.onCounterTwoClick()
            }
            btnNumber3.setOnClickListener {
                presenter.onCounterThreeClick()
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }


    override fun setCounterOne(counter: String) = with(binding) {
        tvText1.text = counter
    }

    override fun setCounterTwo(counter: String) = with(binding) {
        tvText2.text = counter
    }

    override fun setCounterThree(counter: String) = with(binding) {
        tvText3.text = counter
    }
}