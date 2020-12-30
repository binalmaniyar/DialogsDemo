package com.example.dialogsdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.custom_dailog.*
import kotlinx.android.synthetic.main.custom_dailog.view.*

class CustomDialogFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var rootView: View = inflater.inflate(R.layout.custom_dailog,container,false)

        rootView.btnCancel.setOnClickListener { dismiss() }

        rootView.btnSubmit.setOnClickListener {

            val name = etName.text.toString()

            Toast.makeText(context, "Entered name : $name",Toast.LENGTH_LONG).show()

            dismiss()
        }

        return rootView
    }
}