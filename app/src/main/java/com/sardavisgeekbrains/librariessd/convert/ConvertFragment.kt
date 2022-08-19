package com.sardavisgeekbrains.librariessd.convert

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sardavisgeekbrains.librariessd.GeekBrainsApp
import com.sardavisgeekbrains.librariessd.core.OnBackPressedListener
import com.sardavisgeekbrains.librariessd.databinding.FragmentConvertImageBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ConvertFragment : MvpAppCompatFragment(), ConvertView, OnBackPressedListener {

    companion object {
        fun getInstance(): ConvertFragment {
            return ConvertFragment()
        }
    }

    private var _viewBinding: FragmentConvertImageBinding? = null
    private val viewBinding get() = _viewBinding!!
    private var imageUri: Uri? = null

    private val presenter: ConvertPresenter by moxyPresenter {
        ConvertPresenter(ConverterJpgToPng(requireContext()),GeekBrainsApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentConvertImageBinding.inflate(inflater, container, false).also { _viewBinding = it }.root

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 1000) {
            imageUri = data?.data
            imageUri?.let { presenter.originalImageSelected(it) }
        }
    }

    override fun onBackPressed() = presenter.onBackPressed()

    override fun init() {
        hideProgressBar()
        hideErrorBar()
        btnStartConvertDisabled()
        btnAbortConvertDisabled()
        signGetStartedShow()
        signAbortConvertHide()
        signWaitingShow()
        viewBinding.btnImageSelection.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/jpg"
            startActivityForResult(intent, 1000)
        }
        viewBinding.btnStartConverting.setOnClickListener {
            imageUri?.let(presenter::startConvertingPressed)
        }
        viewBinding.btnAbort.setOnClickListener {
            presenter.abortConvertImagePressed()
        }
    }

    override fun showOriginImage(uri: Uri) {
        viewBinding.imgViewOriginalImg.setImageURI(uri)
    }

    override fun showConvertedImage(uri: Uri) {
        viewBinding.imgViewConvertedImg.setImageURI(uri)
    }

    override fun showProgressBar() {
        viewBinding.progressBar2.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        viewBinding.progressBar2.visibility = View.GONE
    }

    override fun showErrorBar() {
        viewBinding.imgViewConvertedImg.setImageURI(null)
        viewBinding.imgViewErrorSign.visibility = View.VISIBLE
    }

    override fun hideErrorBar() {
        viewBinding.imgViewErrorSign.visibility = View.GONE
    }

    override fun btnStartConvertEnable() {
        viewBinding.btnStartConverting.isEnabled = true
    }

    override fun btnStartConvertDisabled() {
        viewBinding.btnStartConverting.isEnabled = false
    }

    override fun btnAbortConvertEnabled() {
        viewBinding.btnAbort.isEnabled = true
    }

    override fun btnAbortConvertDisabled() {
        viewBinding.btnAbort.isEnabled = false
    }

    override fun signAbortConvertShow() {
        viewBinding.imgViewConvertedImg.setImageURI(null)
        viewBinding.imgViewCancelSign.visibility = View.VISIBLE
    }

    override fun signAbortConvertHide() {
        viewBinding.imgViewCancelSign.visibility = View.GONE
    }

    override fun signGetStartedShow() {
        viewBinding.imgViewGetStartedSign.visibility = View.VISIBLE
    }

    override fun signGetStartedHide() {
        viewBinding.imgViewGetStartedSign.visibility = View.GONE
    }

    override fun signWaitingShow() {
        viewBinding.imgViewConvertedImg.setImageURI(null)
        viewBinding.imgViewWaitingSign.visibility = View.VISIBLE
    }

    override fun signWaitingHide() {
        viewBinding.imgViewWaitingSign.visibility = View.GONE
    }

}