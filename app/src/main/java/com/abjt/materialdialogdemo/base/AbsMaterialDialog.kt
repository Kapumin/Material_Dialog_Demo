package com.abjt.materialdialogdemo.base

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.abjt.materialdialogdemo.isShowGone
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.WhichButton
import com.afollestad.materialdialogs.actions.getActionButton

abstract class AbsMaterialDialog<resultType : Any> : DialogFragment() {

    protected lateinit var materialDialog: MaterialDialog
    protected var dialogTitle: String? = ""
    protected var dialogMessage: String? = ""
    protected var positiveButtonLabel: String = "Confirm"
    protected var negativeButtonLabel: String = "Cancel"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        readBundle(savedInstanceState)
        initMaterialDialog()
        showMaterialDialogActionButtons(false)
    }

    private fun initMaterialDialog() {
        materialDialog = MaterialDialog(requireActivity()).apply {
            title(text = dialogTitle)
            message(text = dialogMessage)
            positiveButton(text = positiveButtonLabel)
            negativeButton(text = negativeButtonLabel)
        }
    }

    //later call this fun to show action buttons whereever required
    protected fun showMaterialDialogActionButtons(isShow: Boolean) {
        materialDialog.getActionButton(WhichButton.POSITIVE).isShowGone(isShow)
        materialDialog.getActionButton(WhichButton.NEGATIVE).isShowGone(isShow)
    }

    abstract fun readBundle(savedInstanceState: Bundle?)

    abstract fun sendResult(result: resultType)
}