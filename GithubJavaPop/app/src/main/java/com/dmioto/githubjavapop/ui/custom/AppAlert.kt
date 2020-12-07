package com.dmioto.githubjavapop.ui.custom

import android.app.Notification
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.text.toSpanned
import com.dmioto.githubjavapop.R

object AppAlert {

    enum class TopAlertType {
        ERROR, DISCONNECTED, INFO, WARNING, SUCCESS
    }

    interface Action {
        fun onSBAlertActionClick();
    }

    fun topAlert(where: Context, type: TopAlertType, description: String, action: Action? = null): AlertDialog {
        val layoutInflater = LayoutInflater.from(where)
        val confirmLayout = layoutInflater.inflate(R.layout.git_alert_top_layout, null)
        val builder = AlertDialog.Builder(where, R.style.SBAlert_Top).setView(confirmLayout)
        val dialog = builder.create()

        /* Layout Attrs */
        val closeImg = confirmLayout.findViewById<ImageView>(R.id.closeImg)
        val alertDescription = confirmLayout.findViewById<TextView>(R.id.alertDescription)
        alertDescription.text = description.toSpanned()
        closeImg.setOnClickListener { dialog.dismiss() }
        alertDescription.setOnClickListener { action?.onSBAlertActionClick() }

        when (type) {
            TopAlertType.ERROR -> confirmLayout.setBackgroundColor(ContextCompat.getColor(where, R.color.error))
            TopAlertType.DISCONNECTED -> {
                confirmLayout.setBackgroundColor(ContextCompat.getColor(where, R.color.dark_grey))
                closeImg.visibility = View.GONE
                dialog.setCanceledOnTouchOutside(false)
            }
            TopAlertType.INFO -> confirmLayout.setBackgroundColor(ContextCompat.getColor(where, R.color.accent))
            TopAlertType.WARNING -> {
                confirmLayout.setBackgroundColor(ContextCompat.getColor(where, R.color.warning_yellow))
                alertDescription.setTextColor(ContextCompat.getColor(where, R.color.dark_grey))
                alertDescription.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_info, 0, 0, 0)
                alertDescription.compoundDrawablePadding = 16
                closeImg.visibility = View.GONE
            }
            TopAlertType.SUCCESS -> {
                confirmLayout.setBackgroundColor(ContextCompat.getColor(where, R.color.rise))
                closeImg.setImageResource(R.drawable.ic_success_check)
            }
        }

        /* Force SBAlertBackground hack */
        val window = dialog.window!!
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
        window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

        val params = window.attributes
        params.horizontalMargin = 0f
        params.gravity = Gravity.TOP
        params.dimAmount = 0f
        params.width = WindowManager.LayoutParams.MATCH_PARENT
        params.height = WindowManager.LayoutParams.WRAP_CONTENT
        window.attributes = params

        return dialog
    }
}