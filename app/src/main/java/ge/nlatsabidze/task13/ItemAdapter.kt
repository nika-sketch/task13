package ge.nlatsabidze.task13

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ge.nlatsabidze.task13.databinding.ItemBinding

class ItemAdapter(): RecyclerView.Adapter<ItemAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root)

    var info: List<Content> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            val currentItem = info[position]
            tvDescription.text = currentItem.description
            tvTitle.text = currentItem.title

            Glide.with(holder.itemView.context)
                .load(currentItem.imgUrl)
                .into(ivImage);

            tvPublishdate.text = currentItem.createdAt as CharSequence?
        }
    }

    override fun getItemCount() = info.size
}