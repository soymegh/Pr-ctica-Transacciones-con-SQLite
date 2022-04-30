 package model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import model.dao.ClasificacionDao
import model.dao.GeneroDao
import model.entities.ClasificacionEntity
import model.entities.GeneroEntity

interface MainDataBaseProvider{
    fun GeneroDao(): GeneroDao
    fun ClasificacionDao() : ClasificacionDao
}

@Database (entities = [GeneroEntity::class, ClasificacionEntity::class],
    version = 1
)
abstract class MainDataBase: RoomDatabase(), MainDataBaseProvider {
    abstract override fun GeneroDao(): GeneroDao
    abstract override fun ClasificacionDao() : ClasificacionDao
    companion object{
        @Volatile
        private var INSTANCE: MainDataBase? = null

        fun getInstance(context: Context):MainDataBase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MainDataBase::class.java,
                        "database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}