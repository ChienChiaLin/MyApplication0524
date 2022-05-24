package com.example.myapplication0524

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert
    fun insertProd(pro:Product)

    @Query(" select * from products where proName= :pro")
    fun findProd(pro:String):List<Product>

    @Query("Delete from products where proName=:pro")
    fun delProd(pro:String)

    @Query("Select * from products")
    fun getAll():List<Product>
}