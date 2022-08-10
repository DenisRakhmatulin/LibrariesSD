package com.sardavisgeekbrains.librariessd.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sardavisgeekbrains.librariessd.CountersPresenter
import com.sardavisgeekbrains.librariessd.MainView
import com.sardavisgeekbrains.librariessd.databinding.ActivityMainBinding
import com.sardavisgeekbrains.librariessd.model.GithubUser
import com.sardavisgeekbrains.librariessd.repository.GithubRepository
import com.sardavisgeekbrains.librariessd.repository.impl.CountersRepository
import com.sardavisgeekbrains.librariessd.repository.impl.GithubRepositoryImpl
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter


class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val adapter = UserAdapter()

    private val presenter by moxyPresenter { CountersPresenter(GithubRepositoryImpl()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            rvGithubUsers.layoutManager = LinearLayoutManager(this@MainActivity)
            rvGithubUsers.adapter = adapter
            //rvGithubUsers.setItemViewCacheSize(1)
        }
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }


}