package com.example.kotlinavanzado.dogList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kotlinavanzado.databinding.ActivityMainBinding
import com.example.kotlinavanzado.databinding.DogListItemBinding
import com.example.kotlinavanzado.model.Dog


class DogAdapter: ListAdapter<Dog, DogAdapter.DogViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Dog>() {
        override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem.id === newItem.id
        }
    }

    private var onItemClickListener:((Dog)-> Unit)?= null
    fun setOnItemClickListener(onItemClickListener: (Dog)-> Unit){
        this.onItemClickListener = onItemClickListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {


        val binding = DogListItemBinding.inflate(LayoutInflater.from(parent.context))
         return  DogViewHolder(binding)
     }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dog = getItem(position)
        holder.bind(dog)
     }

inner class DogViewHolder(val binding: DogListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(dog:Dog){
        binding.dogListItemLayout.setOnClickListener{
            onItemClickListener?.invoke(dog)
        }
         binding.dogImage.load(dog.imageUrl)

    }
}
}