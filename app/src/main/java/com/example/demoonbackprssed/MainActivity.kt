package com.example.demoonbackprssed

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demoonbackprssed.databinding.ActivityMainBinding
import com.example.demoonbackprssed.databinding.OnBackPressedBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCancel.setOnClickListener {
            val customDialog = Dialog(this)
            val dialogBinding = OnBackPressedBinding.inflate(layoutInflater)
            customDialog.setContentView(dialogBinding.root)
            customDialog.setCanceledOnTouchOutside(false)
            customDialog.onBackPressed()
            dialogBinding.btnCancel.setOnClickListener {
                customDialog.dismiss()
            }
            dialogBinding.btnExit.setOnClickListener {
                this@MainActivity.finish()
                customDialog.dismiss()
            }
            customDialog.show()
        }
    }
}

