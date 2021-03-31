package com.sean.petinfo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Author: Sean-Shen
 * Date: 2021/3/31
 * Desc:
 */
@Entity(tableName = "petInfo")
class PetInfoEntity {

    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "pet_id", defaultValue = "a")
    lateinit var petId: String

    @ColumnInfo(name = "pet_name", defaultValue = "b")
    lateinit var petName: String

    @ColumnInfo(name = "pet_engname", defaultValue = "c")
    lateinit var petEngName: String

    @ColumnInfo(name = "pet_price", defaultValue = "d")
    lateinit var petPrice: String

    @ColumnInfo(name = "pet_avatar", defaultValue = "e")
    lateinit var petAvatar: String

}