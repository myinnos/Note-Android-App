package `in`.myinnos.androidnote

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
abstract class NotesDao {

    // to insert data
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: Note) {
    }

    // to delete data
    @Delete
    fun delete(note: Note) {
    }

    // to update data
    @Update
    fun update(note: Note) {
    }

    // to read the data (all the data)
    @Query("Select * from notesTable order by id ASC")
    //fun getAllNotes(): LiveData<List<Note>>
    fun getAllNotes() {
    }

}