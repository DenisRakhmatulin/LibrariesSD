package com.sardavisgeekbrains.librariessd.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.sardavisgeekbrains.librariessd.GeekBrainsApp
import com.sardavisgeekbrains.librariessd.R
import com.sardavisgeekbrains.librariessd.core.OnBackPressedListener
import com.sardavisgeekbrains.librariessd.databinding.ActivityMainBinding
import com.sardavisgeekbrains.librariessd.model.GithubUser
import com.sardavisgeekbrains.librariessd.repository.impl.GithubRepositoryImpl
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter


class MainActivity : MvpAppCompatActivity(), MainView {

    private val navigator = AppNavigator(this, R.id.containerMain)
    private lateinit var binding: ActivityMainBinding

    private val presenter by moxyPresenter { MainPresenter(GeekBrainsApp.instance.router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        GeekBrainsApp.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        GeekBrainsApp.instance.navigationHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach { currentFragment ->
            if (currentFragment is OnBackPressedListener && currentFragment.onBackPressed()) {
                return
            }
        }
        presenter.onBackPressed()

    }

}