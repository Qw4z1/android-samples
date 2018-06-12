package se.devies.myfirstapp.networking

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_networking.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import se.devies.myfirstapp.R

class NetworkingActivity : AppCompatActivity() {


    private lateinit var githubService: GitHubInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_networking)

        networkingRecyclerView.adapter = RepoAdapter()
        networkingRecyclerView.layoutManager = LinearLayoutManager(this)

        val padding = resources.getDimension(R.dimen.repo_item_padding)

        networkingRecyclerView.addItemDecoration(RepoDecoration(padding.toInt()))

        val retrofit = initClient()
        githubService = retrofit.create(GitHubInterface::class.java)

        fab.setOnClickListener { fetchRepos() }
    }

    private fun initClient() =
            Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(OkHttpClient())
                    .build()!!

    private fun fetchRepos() {
        updateData(ArrayList())
        val dialog = ProgressDialog(this)
        dialog.setMessage("Fetching repos...")
        dialog.setCancelable(false)
        dialog.show()

        val call = githubService.listRepos("Qw4z1")
        call.enqueue(object : Callback<List<Repository>> {
            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                dialog.dismiss()
            }

            override fun onResponse(call: Call<List<Repository>>, response: Response<List<Repository>>) {
                dialog.dismiss()
                updateData(response.body()!!)
            }

        })
    }

    fun updateData(repos: List<Repository>) {
        (networkingRecyclerView.adapter as RepoAdapter).repos = repos
        networkingRecyclerView.adapter.notifyDataSetChanged()
    }

}