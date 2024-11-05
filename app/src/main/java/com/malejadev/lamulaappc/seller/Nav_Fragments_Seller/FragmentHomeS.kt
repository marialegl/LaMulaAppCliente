package com.malejadev.lamulaappc.seller.Nav_Fragments_Seller

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.malejadev.lamulaappc.R
import com.malejadev.lamulaappc.databinding.FragmentHomeSBinding
import com.malejadev.lamulaappc.seller.Bottom_Nav_Fragments_Seller.FragmentMyProductsS
import com.malejadev.lamulaappc.seller.Bottom_Nav_Fragments_Seller.FragmentOrdersS


class FragmentHomeS : Fragment() {

    private lateinit var binding : FragmentHomeSBinding
    private lateinit var mContext : Context

    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentHomeSBinding.inflate(inflater, container, false)

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId){
                R.id.op_my_products_s -> {
                    replaceFragment(FragmentMyProductsS())
                }
                R.id.op_my_orders_s -> {
                    replaceFragment(FragmentOrdersS())
                }
            }
            true
        }

        replaceFragment(FragmentMyProductsS())
        binding.bottomNavigation.selectedItemId = R.id.op_my_products_s

        binding.addFab.setOnClickListener {
            Toast.makeText(
                mContext, "Has pressed the floating button",
                Toast.LENGTH_SHORT
            ).show()
        }


        return binding.root

    }

    private fun replaceFragment(fragment: Fragment){
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.bottomFragment, fragment)
            .commit()
    }

}