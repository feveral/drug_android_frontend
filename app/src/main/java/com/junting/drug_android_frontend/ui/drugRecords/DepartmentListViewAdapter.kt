package com.junting.drug_android_frontend.ui.drugRecords

import android.content.Context
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class DepartmentListViewAdapter(
    private val context: Context,
    private val viewModel: DepartmentListViewModel,
    private val drugRecordsDepartmentPage: DrugRecordsDepartmentPage
) :
    RecyclerView.Adapter<DepartmentListViewAdapter.MyViewHolder>() {

    class MyViewHolder(val button: Button) : RecyclerView.ViewHolder(button)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val button = Button(context)

        // 設定 margin
        val layoutParams = ViewGroup.MarginLayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(50, 40, 50, 0) // 左、上、右、下的 margin
        button.layoutParams = layoutParams

        // 設定 padding
        button.setPadding(0, 50, 0, 50) // 左、上、右、下各的 padding

        return MyViewHolder(button)
    }

    override fun getItemCount(): Int {
        return viewModel.departments.value?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.button.text = viewModel.departments.value?.get(position)?.name
        holder.button.setOnClickListener {
            // Button click listener logic
            drugRecordsDepartmentPage.initDrugRecordsByDepartmentAdapter(viewModel.departments.value?.get(position)?.name.toString())
            drugRecordsDepartmentPage.initDrugRecordsByDepartmentRecyclerView()
        }
    }
}
