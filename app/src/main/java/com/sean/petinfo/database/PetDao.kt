package com.sean.petinfo.database

import androidx.room.*

/**
 * Author: Sean-Shen
 * Date: 2021/3/31
 * Desc:
 */
@Dao
interface PetDao {

    @Insert
    fun insert(petInfoEntity: PetInfoEntity)

    @Delete
    fun delete(petInfoEntity: PetInfoEntity)

    @Update
    fun update(petInfoEntity: PetInfoEntity)

    @Update
    fun saveToDb(petList: MutableList<PetInfoEntity>)

    @Query("SELECT * FROM petInfo")
    fun getAllData(): MutableList<PetInfoEntity>?

    @Query("SELECT * FROM petInfo WHERE id = :id")
    fun query(id: Int): MutableList<PetInfoEntity>
}