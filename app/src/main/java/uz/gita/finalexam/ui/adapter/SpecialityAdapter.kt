package uz.gita.finalexam.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.finalexam.data.model.SpecialityData
import uz.gita.finalexam.databinding.ItemSpecialityBinding

class SpecialityAdapter : ListAdapter<SpecialityData,SpecialityAdapter.Holder>(MyDiffUtil) {


    object MyDiffUtil : DiffUtil.ItemCallback<SpecialityData>(){
        override fun areItemsTheSame(oldItem: SpecialityData, newItem: SpecialityData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SpecialityData, newItem: SpecialityData): Boolean {
            return oldItem == newItem
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemSpecialityBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    inner class Holder(private val binding:ItemSpecialityBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            getItem(position).apply {
                binding.imgSpecialist.setImageResource(imgResId)
                binding.txtName.text = this.name
            }
        }
    }

}