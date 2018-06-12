package se.devies.myfirstapp.networking

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_repo_view.view.*
import se.devies.myfirstapp.R

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.RepoHolder>() {

    var repos: List<Repository> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoHolder =
            RepoHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_repo_view, parent, false))

    override fun getItemCount() = repos.count()

    override fun onBindViewHolder(holder: RepoHolder, position: Int) {
        val repo = repos[position]
        holder.itemView.repoName.text = repo.name
        holder.itemView.repoOwner.text = repo.owner.login
    }

    inner class RepoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

}
