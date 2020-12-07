package com.dmioto.githubjavapop.ui.core.base

import android.content.Context
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.dmioto.githubjavapop.R
import kotlinx.android.synthetic.main.git_toolbar.*

internal abstract class BaseActivity() : AppCompatActivity(), BaseView {

    private var loadingLayout: View? = null
    private lateinit var rootLayout: ViewGroup
    lateinit var gitToolbar: Toolbar

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun setupToolbar(title: String? = null, titleColor: Int? = null, withReturnButton: Boolean = true,
                             backBtnType: BackButtonType = BackButtonType.LEFT_BLUE) = runOnUiThread {
        toolbar?.let {
            it.bringToFront()
            changeBackIcon(backBtnType)
            val titleTextView = it.findViewById(R.id.centeredTitle) as TextView
            titleTextView.text = title
            titleColor?.let { titleTextView.setTextColor(ContextCompat.getColor(this, titleColor)) }
            setSupportActionBar(it)
        }

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(withReturnButton)
            it.setDisplayShowTitleEnabled(false)
        }
    }

    fun setupToolbar(title: String? = null, withReturnButton: Boolean = true, backBtnType: BackButtonType = BackButtonType.LEFT_BLUE) {
        setupToolbar(title, null, withReturnButton, backBtnType)
    }

    private fun changeBackIcon(backBtnType: BackButtonType) {
        when (backBtnType) {
            BackButtonType.LEFT_GRAY -> {
                toolbar.setNavigationIcon(R.drawable.ic_blue_arrow) // TODO: Change to left gray arrow icon
            }
            BackButtonType.LEFT_BLUE -> {
                toolbar.setNavigationIcon(R.drawable.ic_blue_arrow)
            }
            BackButtonType.UP_BLUE -> {
                toolbar.setNavigationIcon(R.drawable.ic_button_back)
            }
            BackButtonType.GRAY_X -> {
                toolbar.setNavigationIcon(R.drawable.ic_icon_close)
            }
            BackButtonType.WHITE_X -> {
                toolbar.setNavigationIcon(R.drawable.ic_white_close)
            }
            BackButtonType.BLUE_X -> {
                toolbar.setNavigationIcon(R.drawable.ic_blue_close)
            }
            BackButtonType.UP_WHITE -> {
                toolbar.setNavigationIcon(R.drawable.ic_button_up_white)
            }
        }
    }


    fun showDefaultLoading() = runOnUiThread {
        disableTouch()
        createLoading()
    }

    fun hideDefaultLoading() = runOnUiThread {
        enableTouch()
        removeLoading()
    }

    private fun createLoading() = runOnUiThread {
        if (loadingLayout == null) {
            rootLayout = findViewById<View>(android.R.id.content) as ViewGroup
            val layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            loadingLayout = layoutInflater.inflate(R.layout.git_loading, rootLayout, true)
            hideKeyboard()
        }
    }

    private fun removeLoading() = runOnUiThread {
        if (loadingLayout != null) {
            val loading = rootLayout.findViewById<View>(R.id.loader)
            rootLayout.removeView(loading)
            loadingLayout = null
        }
    }

    override fun enableTouch() = runOnUiThread {
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    override fun disableTouch() = runOnUiThread {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    }

    override fun hideKeyboard() = runOnUiThread {
        val view = if (currentFocus != null) currentFocus else View(this)
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        if (view != null) {
            imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    fun showKeyboard(view: EditText)  = runOnUiThread {
        view.requestFocus()
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }


}

enum class BackButtonType {
    UP_BLUE,
    LEFT_BLUE,
    LEFT_GRAY,
    GRAY_X,
    WHITE_X,
    BLUE_X,
    UP_WHITE;
}