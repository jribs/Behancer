package com.inviscidlabs.behancer.ui.home

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.inviscidlabs.behancer.R
import com.inviscidlabs.behancer.model.AllFields



class CreativeFieldRecyclerAdapter(private val viewModel: HomeViewModel, private val lifecycleOwner: LifecycleOwner):
        RecyclerView.Adapter<CreativeFieldRecyclerAdapter.CreativeFieldViewHolder>(){

        private val listOfCreativeFields = mutableListOf<AllFields>()


        init {

            viewModel.allFields.observe(lifecycleOwner, Observer {
                creativeFieldsFromRetro ->
                listOfCreativeFields.clear()
                if(creativeFieldsFromRetro!=null){
                    listOfCreativeFields.addAll(creativeFieldsFromRetro)
                    notifyDataSetChanged()
                }
            })


        }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CreativeFieldViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_creative_field, parent, false)
        val temporaryViewHolder = CreativeFieldViewHolder(v)
        temporaryViewHolder.fieldName = v.findViewById(R.id.textview_creativeField_item)
        return temporaryViewHolder
    }

    override fun getItemCount() = listOfCreativeFields.size

    override fun onBindViewHolder(holder: CreativeFieldViewHolder?, position: Int) {
        holder?.bindCreativeFields(listOfCreativeFields[position])
    }

    class CreativeFieldViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        lateinit var fieldName:     TextView


        fun bindCreativeFields(fields: AllFields){
            fieldName.setText(fields.name)
        }

    }

}

