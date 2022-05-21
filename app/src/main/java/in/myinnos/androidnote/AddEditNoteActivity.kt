package `in`.myinnos.androidnote

import `in`.myinnos.androidnote.database.Note
import `in`.myinnos.androidnote.databinding.ActivityAddEditNoteBinding
import `in`.myinnos.androidnote.model.NoteViewModal
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import java.text.SimpleDateFormat
import java.util.*

class AddEditNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddEditNoteBinding
    lateinit var viewModal: NoteViewModal
    var noteID = -1;

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[NoteViewModal::class.java]

        val noteType = intent.getStringExtra("noteType")

        if (noteType.equals("Edit")) {
            val noteTitle = intent.getStringExtra("noteTitle")
            val noteDescription = intent.getStringExtra("noteDescription")
            noteID = intent.getIntExtra("noteId", -1)
            binding.idBtn.text = "Update Note"
            binding.idEdtNoteName.setText(noteTitle)
            binding.idEdtNoteDesc.setText(noteDescription)
        } else {
            binding.idBtn.text = "Save Note"
        }

        binding.idBtn.setOnClickListener {
            val noteTitle = binding.idEdtNoteName.text.toString()
            val noteDescription = binding.idEdtNoteDesc.text.toString()

            if (noteType.equals("Edit")) {
                if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDateAndTime: String = sdf.format(Date())
                    val updatedNote = Note(noteTitle, noteDescription, currentDateAndTime)
                    updatedNote.id = noteID
                    viewModal.updNote(updatedNote)
                    Toast.makeText(this, "Note Updated..", Toast.LENGTH_LONG).show()
                }
            } else {
                if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDateAndTime: String = sdf.format(Date())
                    viewModal.insertNote(Note(noteTitle, noteDescription, currentDateAndTime))
                    Toast.makeText(this, "$noteTitle Added", Toast.LENGTH_LONG).show()
                }
            }
            // opening the new activity on below line
            //startActivity(Intent(applicationContext, MainActivity::class.java))
            this.finish()
        }

    }
}
