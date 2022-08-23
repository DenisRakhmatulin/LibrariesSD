package com.sardavisgeekbrains.librariessd.core.nav

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.sardavisgeekbrains.librariessd.convert.ConvertFragment
import com.sardavisgeekbrains.librariessd.details.DetailsFragment
import com.sardavisgeekbrains.librariessd.user.UserFragment

object UsersScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.getInstance()
    }
}

data class DetailsScreen(private val login: String) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return DetailsFragment.getInstance(login)
    }
}

object ConvertScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return ConvertFragment.getInstance()
    }
}