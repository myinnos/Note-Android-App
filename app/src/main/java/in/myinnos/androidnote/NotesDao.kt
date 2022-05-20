package `in`.myinnos.androidnote

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
abstract class NotesDao {

    // to insert data
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note) {
    }

    // to delete data
    @Delete
    suspend fun delete(note: Note) {
    }

    // to update data
    @Update
    suspend fun update(note: Note) {
    }

    // to read the data (all the data)
    @Query("Select * from notesTable order by id ASC")
    abstract fun getAllNotes(): LiveData<List<Note>>

}