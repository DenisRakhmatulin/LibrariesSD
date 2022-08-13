package com.sardavisgeekbrains.librariessd.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sardavisgeekbrains.librariessd.databinding.FragmentDetailsBinding
import moxy.MvpAppCompatFragment

class DetailsFragment : MvpAppCompatFragment() {

    companion object {
        fun getInstance(login: String): DetailsFragment {
            return DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString("login", login)
                }
            }
        }
    }

    private lateinit var viewBinding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentDetailsBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        if (bundle != null) {
            viewBinding.tvDetails.text = bundle.getString("login")
        } else {
            //если ничего не пришло
        }
    }

}