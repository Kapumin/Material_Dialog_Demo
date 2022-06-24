package com.abjt.materialdialogdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.abjt.materialdialogdemo.*

class DialogHostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_host_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.dialog_opener).setOnClickListener {
            parentFragmentManager.run {
                ListMaterialDialog.create(
                    "List Dialog",
                    arrayListOf("First Item", "Second Item", "Third Item")
                ).show(requireActivity().supportFragmentManager, LIST_MATERIAL_DIALOG)
                setFragmentResultListener(
                    REQUEST_KEY_LIST_DIALOG, this@DialogHostFragment
                ) { requestKey, result ->
                    when (requestKey) {
                        REQUEST_KEY_LIST_DIALOG -> {
                            view.findViewById<TextView>(R.id.tv_clicked_position).text = result.getInt(CLICKED_INDEX).toString()
                            view.findViewById<TextView>(R.id.tv_clicked_item).text =result.getString(CLICKED_LIST_ITEM)
                        }
                    }
                }
            }
        }
    }
}