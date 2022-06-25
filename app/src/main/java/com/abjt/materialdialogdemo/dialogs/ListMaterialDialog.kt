package com.abjt.materialdialogdemo.dialogs

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import com.abjt.materialdialogdemo.*
import com.abjt.materialdialogdemo.base.AbsMaterialDialog
import com.afollestad.materialdialogs.list.listItemsSingleChoice

class ListMaterialDialog : AbsMaterialDialog<Pair<Int, String>>() {

    private lateinit var items: ArrayList<String>

    override fun readBundle(savedInstanceState: Bundle?) {
        arguments?.let { bundle ->
            dialogTitle = bundle.getString(MATERIAL_DIALOG_TITLE)
            items = bundle.getStringArrayList(MATERIAL_DIALOG_LIST_ITEMS) as ArrayList<String>
        }
    }

    @SuppressLint("CheckResult")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        materialDialog.show {
            // set initialSelection according to your last saved item in your preference
            listItemsSingleChoice(items = items, initialSelection = 0) { dialog, index, text ->
                sendResult(Pair(index, text.toString()))
            }
        }.also {
            return it
        }
    }

    override fun sendResult(result: Pair<Int, String>) {
        parentFragmentManager.setFragmentResult(
            REQUEST_KEY_SINGLE_CHOICE_LIST,
            Bundle().apply {
                putInt(CLICKED_INDEX, result.first)
                putString(CLICKED_LIST_ITEM, result.second)
            })
    }

    companion object {
        fun create(title: String, items: ArrayList<String>) = ListMaterialDialog().apply {
            arguments = Bundle().apply {
                putString(MATERIAL_DIALOG_TITLE, title)
                putStringArrayList(MATERIAL_DIALOG_LIST_ITEMS, items)
            }
        }
    }
}