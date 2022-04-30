package model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Clasificacion")
 data class ClasificacionEntity (

    @PrimaryKey(autoGenerate = true)
    val idClasificacion: Int,

    @ColumnInfo(name = "nombre")
    val nombreClasificacion: String,

    @ColumnInfo(name = "activo")
    val activo: String
         )