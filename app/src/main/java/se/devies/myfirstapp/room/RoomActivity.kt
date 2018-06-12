package se.devies.myfirstapp.room

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.android.synthetic.main.holder_view.view.*
import se.devies.myfirstapp.R

class RoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_room)
        roomRecyclerView.layoutManager = LinearLayoutManager(this)
        newNoteButton.setOnClickListener { openNoteActivity() }
        DbTask(this@RoomActivity, {
            notes ->
            roomRecyclerView.adapter = Adapter(notes)
        }).execute()
    }

    private fun openNoteActivity() {
        val intent = Intent(this, NoteActivity::class.java)
        startActivity(intent)
    }

}

class Adapter(private val allNotes: List<Note>) : RecyclerView.Adapter<Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
            Holder(LayoutInflater.from(parent.context).inflate(R.layout.holder_view, parent, false))


    override fun getItemCount(): Int =
            allNotes.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.noteItemText.text = allNotes[position].note
    }

}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}

class DbTask(val context: Context, private val callback: (notes:List<Note>) -> Unit): AsyncTask<Int, String, List<Note>>() {

    override fun doInBackground(vararg params: Int?): List<Note> =
        NoteRoomDatabase.getDatabase(context).wordDao().allWords

    override fun onPostExecute(result: List<Note>) {
        super.onPostExecute(result)
        callback.invoke(result)
    }
}