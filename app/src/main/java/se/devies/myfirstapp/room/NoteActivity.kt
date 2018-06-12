package se.devies.myfirstapp.room

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_note.*
import se.devies.myfirstapp.R

const val NOTE_ID = "note_id"

class NoteActivity : AppCompatActivity() {

    lateinit var note: Note

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        val noteDao = NoteRoomDatabase.getDatabase(this).wordDao()

        val extras = intent.extras
        if (extras != null && extras.containsKey(NOTE_ID)) {
            val noteId = extras.getInt(NOTE_ID)
            note = noteDao.getNote(noteId)
            noteText.text.clear()
            noteText.setText(note.note)
        } else {
            note = Note()
        }

        saveNoteButton.setOnClickListener {
            val text = noteText.text.toString()
            note.note = text
            noteDao.insert(note)
            finish()
        }
    }


}
