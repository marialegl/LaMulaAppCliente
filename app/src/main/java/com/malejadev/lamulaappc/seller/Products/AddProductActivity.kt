package com.malejadev.lamulaappc.seller.Products

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import com.malejadev.lamulaappc.Adapters.AdapterSelectedImage
import com.malejadev.lamulaappc.Models.SelectedImageModel
import com.malejadev.lamulaappc.databinding.ActivityAddProductBinding

class AddProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddProductBinding
    private var imageUri: Uri? = null
    private lateinit var selectedImagesArrayList: ArrayList<SelectedImageModel>
    private lateinit var adapterSelectedImage: AdapterSelectedImage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        selectedImagesArrayList = ArrayList()

        binding.imgAddProduct.setOnClickListener {
            selectImage()
        }

        uploadImages()


    }

    private fun uploadImages() {
        adapterSelectedImage = AdapterSelectedImage(this, selectedImagesArrayList)
        binding.RVImagesProduct.adapter = adapterSelectedImage

    }

    private fun selectImage() {
        ImagePicker.with(this)
            .crop()
            .compress(1024)
            .maxResultSize(1080, 1080)
            .createIntent { intent ->
                resulImage.launch(intent)
            }

    }

    private val resulImage =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                imageUri = data!!.data
                val time = "$(Constants().getDeviceTime()}"

                val selectedImageModel = SelectedImageModel(time, imageUri, null, false)
                selectedImagesArrayList.add(selectedImageModel)
                uploadImages()

            } else {
                Toast.makeText(this, "Action cancelled", Toast.LENGTH_SHORT).show()
            }
        }
}