package com.example.bottomsheetdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomSheet()
        initBottomSheetDialog()
    }

    private fun initBottomSheetDialog() {
        val changeDialog = findViewById<Button>(R.id.change_dialog)
        val dialog = BottomSheetDialog(this)
        val v = layoutInflater.inflate(R.layout.activity_bottom_sheet_dialog, null)
        dialog.setContentView(v)

        changeDialog.setOnClickListener {
            if (dialog.isShowing) {
                dialog.hide()
            }
            if (!dialog.isShowing) {
                dialog.show()
            }
        }
    }

    private fun initBottomSheet() {
        val bottomSheet = findViewById<NestedScrollView>(R.id.bottom_sheet)
        val behavior = BottomSheetBehavior.from(bottomSheet)
        val showBottomSheet = findViewById<Button>(R.id.show_bottom_sheet)
        val hideBottomSheet = findViewById<Button>(R.id.hide_bottom_sheet)

        behavior.state = BottomSheetBehavior.STATE_HIDDEN
        hideBottomSheet.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_HIDDEN
        }

        showBottomSheet.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.d("bottom", "onSlide")
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                Log.d("bottom", "onStateChanged")
            }
        })
    }
}
