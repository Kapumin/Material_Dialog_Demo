package com.abjt.materialdialogdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.abjt.materialdialogdemo.*
import com.abjt.materialdialogdemo.MaterialDialogType.ACTION_BUTTON
import com.abjt.materialdialogdemo.MaterialDialogType.SINGLE_CHOICE_LIST
import com.abjt.materialdialogdemo.dialogs.ActionButtonDialog
import com.abjt.materialdialogdemo.dialogs.ListMaterialDialog

class DialogHostFragment : Fragment() {

    private lateinit var tvClickedPosition: TextView
    private lateinit var tvClickedItemName: TextView
    private lateinit var tvClickedActionButton: TextView

    private lateinit var listDialogOpener: Button
    private lateinit var actionDialogOpener: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_host_fragment, container, false).apply {
            tvClickedPosition = findViewById(R.id.tv_clicked_position)
            tvClickedItemName = findViewById(R.id.tv_clicked_item)
            listDialogOpener = findViewById(R.id.list_dialog_opener)

            tvClickedActionButton = findViewById(R.id.tv_clicked_action)
            actionDialogOpener = findViewById(R.id.action_dialog_opener)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listDialogOpener.setOnClick {
            openListDialog()
        }
        actionDialogOpener.setOnClick {
            openActionButtonDialog()
        }
    }

    private fun openListDialog() {
        ListMaterialDialog.create(
            "List Dialog",
            arrayListOf("First Item", "Second Item", "Third Item")
        ).show(requireActivity().supportFragmentManager, LIST_MATERIAL_DIALOG_TAG).also {
            setFragmentResultListener(SINGLE_CHOICE_LIST)
        }
    }

    private fun openActionButtonDialog() {
        ActionButtonDialog.create(
            "Action Button Dialog",
            "This is action button dialog demo message"
        ).show(requireActivity().supportFragmentManager, ACTION_MATERIAL_DIALOG_TAG).also {
            setFragmentResultListener(ACTION_BUTTON)
        }
    }

    private fun setFragmentResultListener(materialDialogType: MaterialDialogType) {
        parentFragmentManager.setFragmentResultListener(
            materialDialogType.requestKey, this@DialogHostFragment
        ) { requestKey, result ->
            when (requestKey) {
                SINGLE_CHOICE_LIST.requestKey -> {
                    tvClickedPosition.text =
                        result.getInt(CLICKED_INDEX).toString()
                    tvClickedItemName.text =
                        result.getString(CLICKED_LIST_ITEM)
                }
                ACTION_BUTTON.requestKey -> {
                    tvClickedActionButton.text = result.getString(CLICKED_ACTION_BUTTON)
                }
            }
        }
    }
}