package com.abjt.materialdialogdemo.dialogs

import android.app.Dialog
import android.os.Bundle
import com.abjt.materialdialogdemo.CLICKED_ACTION_BUTTON
import com.abjt.materialdialogdemo.MATERIAL_DIALOG_MESSAGE
import com.abjt.materialdialogdemo.MATERIAL_DIALOG_TITLE
import com.abjt.materialdialogdemo.REQUEST_KEY_ACTION_DIALOG
import com.abjt.materialdialogdemo.base.AbsMaterialDialog

class ActionButtonDialog : AbsMaterialDialog<String>() {

    override fun readBundle(savedInstanceState: Bundle?) {
        arguments?.let { bundle ->
            dialogTitle = bundle.getString(MATERIAL_DIALOG_TITLE)
            dialogMessage = bundle.getString(MATERIAL_DIALOG_MESSAGE)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        materialDialog.show {
            showMaterialDialogActionButtons(true)
            positiveButton {
                sendResult("Positive Button")
            }
            negativeButton {
                sendResult("Negative Button")
            }
        }.also {
            return it
        }
    }

    //just sending a clicked action button label pass your own argument according to your needs
    override fun sendResult(result: String) {
        parentFragmentManager.setFragmentResult(REQUEST_KEY_ACTION_DIALOG, Bundle().apply {
            putString(CLICKED_ACTION_BUTTON, result)
        })
    }

    companion object {
        fun create(title: String, msg: String) = ActionButtonDialog().apply {
            arguments = Bundle().apply {
                putString(MATERIAL_DIALOG_TITLE, title)
                putString(MATERIAL_DIALOG_MESSAGE, msg)
            }
        }
    }
}