package com.malejadev.lamulaappc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.malejadev.lamulaappc.client.LoginClientActivity
import com.malejadev.lamulaappc.databinding.ActivitySelectTypeBinding
import com.malejadev.lamulaappc.seller.LoginSellerActivity

class SelectTypeActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.SellerType.setOnClickListener {
            startActivity(Intent(this@SelectTypeActivity, LoginSellerActivity::class.java))
        }

        binding.ClientType.setOnClickListener {
            startActivity(Intent(this@SelectTypeActivity, LoginClientActivity::class.java))
        }


    }
}