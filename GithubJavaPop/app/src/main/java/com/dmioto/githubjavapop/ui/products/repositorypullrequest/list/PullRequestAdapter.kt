package com.dmioto.githubjavapop.ui.products.repositorypullrequest.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dmioto.githubjavapop.R
import com.dmioto.githubjavapop.data.products.repositorypullrequest.entity.PullRequests
import kotlinx.android.synthetic.main.repository_pull_requests_item.view.*

class PullRequestAdapter(private val pullRequests: ArrayList<PullRequests>) : RecyclerView.Adapter<PullRequestAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(pullTitle: String, pullBody: String, userPic: String, username: String) {
            itemView.pull_request_title.text = pullTitle
            itemView.pull_request_body.text = pullBody
            itemView.user.text = username

            Glide.with(itemView.context)
                .load(userPic)
                .circleCrop()
                .into(itemView.user_picture)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repository_pull_requests_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            pullRequests[position].title,
            pullRequests[position].body,
            pullRequests[position].user.avatar_url!!,
            pullRequests[position].user.login!!
        )
    }

    override fun getItemCount(): Int {
        return pullRequests.size
    }
}