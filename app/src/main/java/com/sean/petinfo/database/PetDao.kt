package com.sean.petinfo.database

import androidx.room.*

/**
 * Author: Sean-Shen
 * Date: 2021/3/31
 * Desc: Dao类
 */
@Dao
interface PetDao {

    @Delete   //删除单个数据
    fun delete(petInfoEntity: PetInfoEntity)

    @Query("DELETE FROM petInfo")   //删除全部
    fun deleteAll()

    @Update
    fun update(petInfoEntity: PetInfoEntity)

    @Insert
    fun insert(petInfoEntity: PetInfoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)    //插入数据，策略为重复替换
    fun saveToDb(petList: MutableList<PetInfoEntity>)

    @Query("SELECT * FROM petInfo")   //查询所有数据
    fun getAllData(): MutableList<PetInfoEntity>

    @Query("SELECT * FROM petInfo WHERE id = :id")    //查询特定数据
    fun query(id: Int): MutableList<PetInfoEntity>
}