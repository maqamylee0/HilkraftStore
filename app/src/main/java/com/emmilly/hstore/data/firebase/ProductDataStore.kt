package com.emmilly.hstore.data.firebase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.emmilly.hstore.data.models.Product
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ProductDataStore {
    private val db = Firebase.firestore

    //Create function that will fetch the producta from the database
    fun getProductsInfo(): MutableLiveData<List<Product>> {
        val productLivedata = MutableLiveData<List<Product>>()

        db.collection("products")
            .get()
            .addOnSuccessListener { documents ->
                val listOfProducts: List<Product> = documents.toObjects(Product::class.java)
                productLivedata.value = listOfProducts
            }
            .addOnFailureListener{ error ->
                Log.e("Firebase Error", error.message.toString())
            }

        return productLivedata
    }
}