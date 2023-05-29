package uz.gita.finalexam.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import uz.gita.finalexam.R
import uz.gita.finalexam.data.model.TopDoctorsData
import uz.gita.finalexam.databinding.ItemTopDoctorsBinding

class TopDoctorsAdapter(private val list:List<TopDoctorsData>) : RecyclerView.Adapter<TopDoctorsAdapter.Holder>() {
    private var selectedPos = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemTopDoctorsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }


    inner class Holder(private val binding:ItemTopDoctorsBinding):RecyclerView.ViewHolder(binding.root){
        init {
            binding.txtName.setOnClickListener {
                if (selectedPos != -1){
                    list[selectedPos].isSelected = false
                    notifyItemChanged(selectedPos)
                }
                selectedPos = absoluteAdapterPosition
                list[selectedPos].isSelected = true
                notifyItemChanged(selectedPos)
            }
        }

        fun bind(){
            list[absoluteAdapterPosition].apply {
                binding.txtName.text  = this.name
                binding.txtName.isSelected = this.isSelected
                if (isSelected){
                    binding.txtName.setTextColor(ContextCompat.getColor(binding.root.context,R.color.white))
                }else {
                    binding.txtName.setTextColor(ContextCompat.getColor(binding.root.context,R.color.blue))
                }
            }
        }
    }
}