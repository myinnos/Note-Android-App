package `in`.myinnos.androidnote.database

import androidx.lifecycle.LiveData

class NoteRepository(private val notesDao: NotesDao) {

    val allNotes: LiveData<List<Note>> = notesDao.getAllNotes()

    // insert
    suspend fun insert(note: Note) {
        notesDao.insert(note)
    }

    //delete
    suspend fun delete(note: Note){
        notesDao.delete(note)
    }

    // update
    suspend fun update(note: Note){
        notesDao.update(note)
    }


}