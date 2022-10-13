package com.emmilly.hstore.data.repository

import androidx.lifecycle.MutableLiveData
import com.emmilly.hstore.data.firebase.ProductDataStore
import com.emmilly.hstore.data.models.Product

class ProductsRepository {

    fun getProducts(): MutableLiveData<List<Product>> {
        val productDatasource = ProductDataStore()
        return productDatasource.getProductsInfo()
    }
}