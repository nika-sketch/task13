package ge.nlatsabidze.task13

import android.view.View
import android.widget.Button
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.LoadState
import android.widget.ProgressBar
import android.view.LayoutInflater
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView

class ProgressBarAdapter(private val retry: () -> Unit): LoadStateAdapter<ProgressBarAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }
    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState) = LoadStateViewHolder(parent, retry)

    inner class LoadStateViewHolder(
        parent: ViewGroup,
        retry: () -> Unit
    ) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.progress_bar, parent, false)
    ) {
        private val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)

        fun bind(loadState: LoadState) {
            progressBar.visibility = toVisibility(loadState is LoadState.Loading)
        }

        private fun toVisibility(constraint: Boolean): Int = if (constraint) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}
