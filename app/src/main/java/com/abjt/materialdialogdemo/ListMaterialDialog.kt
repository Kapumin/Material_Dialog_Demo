package com.abjt.materialdialogdemo

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.abjt.materialdialogdemo.base.AbsMaterialDialog
import com.abjt.materialdialogdemo.fragment.DialogHostFragment
import com.afollestad.materialdialogs.list.listItemsSingleChoice

class ListMaterialDialog : AbsMaterialDialog() {

    private lateinit var items: ArrayList<String>

    override fun readBundle(savedInstanceState: Bundle?) {
        arguments?.let { bundle ->
            title = bundle.getString(MATERIAL_DIALOG_TITLE)
            items = bundle.getStringArrayList(MATERIAL_DIALOG_LIST_ITEMS) as ArrayList<String>
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        materialDialog.apply {
            this.listItemsSingleChoice(items = items) { dialog, index, text ->
                parentFragmentManager.setFragmentResult(REQUEST_KEY_LIST_DIALOG, Bundle().apply {
                    putInt(CLICKED_INDEX, index)
                    putString(CLICKED_LIST_ITEM, text.toString())
                    dialog.dismiss()
                })
            }.show()
        }.also {
            return it
        }
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