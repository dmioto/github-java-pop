package com.dmioto.githubjavapop.ui.products.main

import android.os.Bundle
import com.dmioto.githubjavapop.R
import com.dmioto.githubjavapop.ui.core.base.BaseActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import kotlinx.android.synthetic.main.activity_main.*


internal class MainActivity : BaseActivity(), MainView {

    private val presenter: MainPresenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)

        begin.setOnClickListener {
            presenter.navigatePopularJavaRepositories()
        }
    }

    override fun showLoading() { }

    override fun hideLoading() { }
}