package `in`.myinnos.androidnote

import `in`.myinnos.androidnote.adapter.NoteClickDeleteInterface
import `in`.myinnos.androidnote.adapter.NoteClickInterface
import `in`.myinnos.androidnote.adapter.NoteRVAdapter
import `in`.myinnos.androidnote.database.Note
import `in`.myinnos.androidnote.databinding.ActivityMainBinding
import `in`.myinnos.androidnote.model.NoteViewModal
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity(), NoteClickInterface, NoteClickDeleteInterface {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModal: NoteViewModal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.notesRV.layoutManager = LinearLayoutManager(this)
        val noteRVAdapter = NoteRVAdapter(this, this, this)
        binding.notesRV.adapter = noteRVAdapter

        viewModal = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModal::class.java)

        viewModal.allNotes.observe(this, Observer { list ->
            list?.let {
                noteRVAdapter.updateList(it)
            }
        })

        binding.idFAB.setOnClickListener {
            val intent = Intent(this@MainActivity, AddEditNoteActivity::class.java)
            startActivity(intent)
            //this.finish()
        }

    }

    override fun onDeleteIconClick(note: Note) {
        viewModal.delNote(note)
        Toast.makeText(this, "${note.noteTitle} Deleted", Toast.LENGTH_LONG).show()
    }

    override fun onNoteClick(note: Note) {
        val intent = Intent(this@MainActivity, AddEditNoteActivity::class.java)
        intent.putExtra("noteType", "Edit")
        intent.putExtra("noteTitle", note.noteTitle)
        intent.putExtra("noteDescription", note.noteDescription)
        intent.putExtra("noteId", note.id)
        startActivity(intent)
        //this.finish()
    }
}