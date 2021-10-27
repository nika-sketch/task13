package ge.nlatsabidze.task13

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ge.nlatsabidze.task13.databinding.ItemBinding

class UserAdapter(): PagingDataAdapter<User.Data, UserAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    inner class ViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(currentItem: User.Data) {
            Glide.with(itemView.context)
                .load(currentItem.avatar)
                .into(binding.ivImage);
            binding.tvName.text = currentItem.firstName
            binding.tvLastname.text = currentItem.lastName
        }
    }

    class DiffCallback: DiffUtil.ItemCallback<User.Data>() {
        override fun areItemsTheSame(oldItem: User.Data, newItem: User.Data): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: User.Data, newItem: User.Data): Boolean {
            return oldItem == newItem
        }
    }
}