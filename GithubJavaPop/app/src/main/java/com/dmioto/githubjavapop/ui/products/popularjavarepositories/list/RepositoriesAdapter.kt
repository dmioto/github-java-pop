package com.dmioto.githubjavapop.ui.products.popularjavarepositories.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dmioto.githubjavapop.R
import com.dmioto.githubjavapop.data.products.popularjavarepositories.entity.Repository
import kotlinx.android.synthetic.main.popular_java_repositories_item.view.*


class RepositoriesAdapter(private val repositories: ArrayList<Repository>) : RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {

    private var itemClickListener: ItemClickListener? = null

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(repoName: String, repoDescription: String, repoForks: Int, repoStars: Int, ownerName: String, ownerPic: String) {
            itemView.repository_name.text = repoName
            itemView.repository_description.text = repoDescription
            itemView.repository_fork_count.text = repoForks.toString()
            itemView.repository_star_count.text = repoStars.toString()
            itemView.owner_username.text = ownerName

            Glide.with(itemView.context)
                .load(ownerPic)
                .circleCrop()
                .into(itemView.owner_picture)
        }

        fun onClick(itemClickListener: ItemClickListener) {
            itemView.item_repository.setOnClickListener {
                itemClickListener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_java_repositories_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            repositories[position].name!!,
            repositories[position].description!!,
            repositories[position].forks_count!!,
            repositories[position].stargazers_count!!,
            repositories[position].owner!!.login!!,
            repositories[position].owner!!.avatar_url!!
        )

        holder.onClick(itemClickListener!!)
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    fun setOnItemClickListener(itemClickListener: ItemClickListener?) {
        this.itemClickListener = itemClickListener
    }

}