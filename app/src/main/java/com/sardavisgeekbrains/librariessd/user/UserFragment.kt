package com.sardavisgeekbrains.librariessd.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sardavisgeekbrains.librariessd.GeekBrainsApp
import com.sardavisgeekbrains.librariessd.core.OnBackPressedListener
import com.sardavisgeekbrains.librariessd.databinding.FragmentUserListBinding
import com.sardavisgeekbrains.librariessd.main.UserAdapter
import com.sardavisgeekbrains.librariessd.model.GithubUser
import com.sardavisgeekbrains.librariessd.repository.impl.GithubRepositoryImpl
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment: MvpAppCompatFragment(), UserView, OnBackPressedListener {

    companion object {
    fun getInstance(): UserFragment {
        return UserFragment()
    }
}

    private lateinit var viewBinding: FragmentUserListBinding

    private val adapter = UserAdapter()
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(GithubRepositoryImpl(), GeekBrainsApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserListBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            rvGithubUsers.layoutManager = LinearLayoutManager(requireContext())
            rvGithubUsers.adapter = adapter
        }
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    /*override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }*/

    override fun onBackPressed() = presenter.onBackPressed()
}
