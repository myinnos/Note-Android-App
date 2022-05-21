package `in`.myinnos.androidnote.adapter

import `in`.myinnos.androidnote.R
import `in`.myinnos.androidnote.database.Note
import `in`.myinnos.androidnote.databinding.NoteRvItemBinding
import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapter(
    val context: Context, private val noteClickDeleteInterface: NoteClickDeleteInterface,
    private val noteClickInterface: NoteClickInterface
) :
    RecyclerView.Adapter<NoteRVAdapter.ViewHolder>() {

    // variables
    private val allNotes = ArrayList<Note>()

    inner class ViewHolder(var viewBinding: NoteRvItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteRVAdapter.ViewHolder {
        val itemView = NoteRvItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NoteRVAdapter.ViewHolder, position: Int) {
        holder.viewBinding.idTVNote.text = allNotes.get(position).noteTitle
        holder.viewBinding.idTVDate.text = "Last Updated : " + allNotes[position].timestamp

        holder.viewBinding.idIVDelete.setOnClickListener {
            noteClickDeleteInterface.onDeleteIconClick(allNotes[position])
        }
        holder.itemView.setOnClickListener {
            noteClickInterface.onNoteClick(allNotes[position])
        }

    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Note>) {
        allNotes.clear()
        Log.d("NOTES_DATA", newList.toString())
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}

interface NoteClickDeleteInterface {
    fun onDeleteIconClick(note: Note)
}

interface NoteClickInterface {
    fun onNoteClick(note: Note)
}