package `in`.myinnos.androidnote

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class Note {
    // table name
    @Entity(tableName = "notesTable")
    // table column info
    class Note(
        @ColumnInfo(name = "title") val noteTitle: String,
        @ColumnInfo(name = "description") val noteDescription: String,
        @ColumnInfo(name = "timestamp") val timestamp: String,
        @PrimaryKey(autoGenerate = true) val id: Int = 0
    )
}