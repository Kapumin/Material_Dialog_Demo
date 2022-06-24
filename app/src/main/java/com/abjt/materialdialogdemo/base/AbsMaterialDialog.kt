package com.abjt.materialdialogdemo.base

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.WhichButton
import com.afollestad.materialdialogs.actions.getActionButton

abstract class AbsMaterialDialog : DialogFragment() {

    protected lateinit var materialDialog: MaterialDialog
    protected var title: String? = ""
    protected var message: String? = ""
    protected var positiveButtonLabel: String = "Confirm"
    protected var negativeButtonLabel: String = "Cancel"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        readBundle(savedInstanceState)
        initMaterialDialog()
        hideMaterialDialogActionButtons(false)
    }

    private fun initMaterialDialog() {
        materialDialog = MaterialDialog(requireActivity()).apply {
            title(text = title)
            message(text = message)
            positiveButton(text = positiveButtonLabel)
            negativeButton(text = negativeButtonLabel)
        }
    }

    //later call this fun to show action buttons whereever required
    protected fun hideMaterialDialogActionButtons(isShow: Boolean) {
        materialDialog.getActionButton(WhichButton.POSITIVE).isShowGone(isShow)
        materialDialog.getActionButton(WhichButton.NEGATIVE).isShowGone(isShow)
    }

    abstract fun readBundle(savedInstanceState: Bundle?)

}