package model.dao

import androidx.room.*
import model.entities.GeneroEntity

@Dao
interface GeneroDao{

        @Insert (onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(genero: GeneroEntity)

        @Query("SELECT * FROM Genero")
        suspend fun getAll(): List<GeneroEntity>

        @Query("SELECT * FROM Genero where idGenero= :id")
        suspend fun getByIdGenero(id: Int): GeneroEntity

        @Update
        fun update(Genero: GeneroEntity)

        @Delete
        fun delete(Genero: GeneroEntity)
}
