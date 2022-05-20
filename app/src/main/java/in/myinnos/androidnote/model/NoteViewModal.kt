package `in`.myinnos.androidnote.model

import `in`.myinnos.androidnote.database.Note
import `in`.myinnos.androidnote.database.NoteDatabase
import `in`.myinnos.androidnote.database.NoteRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModal(application: Application): AndroidViewModel(application) {

    // variable creation
    private val allNotes: LiveData<List<Note>>
    private val repository: NoteRepository

    // initializations
    init {
        val dao = NoteDatabase.getDatabase(application).getNotesDao()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }

    fun delNote(note: Note) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(note)
    }

    fun updNote(note: Note) = viewModelScope.launch(Dispatchers.IO){
        repository.update(note)
    }

    fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }


}