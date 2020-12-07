package com.dmioto.githubjavapop.ui.products

import android.content.Intent
import androidx.core.app.ActivityOptionsCompat
import com.dmioto.githubjavapop.R
import com.dmioto.githubjavapop.data.products.repositorypullrequest.entity.PullRequests
import com.dmioto.githubjavapop.ui.core.base.BaseActivity
import com.dmioto.githubjavapop.ui.products.popularjavarepositories.PopularJavaRepositoriesActivity
import com.dmioto.githubjavapop.ui.products.repositorypullrequest.RepositoryPullRequestActivity
import org.koin.core.KoinComponent

internal class Navigator(private val activity: BaseActivity) : KoinComponent {

    fun navigatePopularJavaRepositories() {
        val options = ActivityOptionsCompat.makeCustomAnimation(activity, R.anim.slide_in_up, R.anim.slide_out_up)
        val intent = Intent(activity, PopularJavaRepositoriesActivity::class.java)
        activity.startActivity(intent, options.toBundle())
    }

    fun navigateRepositoryPullRequests(owner: String, repo: String) {
        val options = ActivityOptionsCompat.makeCustomAnimation(activity, R.anim.slide_in_up, R.anim.slide_out_up)
        val intent = Intent(activity, RepositoryPullRequestActivity::class.java).apply {
            putExtra(PullRequests.PULL_REQUEST_OWNER, owner)
            putExtra(PullRequests.PULL_REQUEST_REPO, repo)
        }
        activity.startActivity(intent, options.toBundle())
    }
}