package com.nh.roomwithview.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nh.roomwithview.R
import com.nh.roomwithview.entity.UserDetail

class UserListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var userDetail = emptyList<UserDetail>()

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userDepartment: TextView = itemView.findViewById(R.id.textViewDepartment)
        val userName: TextView = itemView.findViewById(R.id.textViewName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return UserViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = userDetail[position]
        holder.userName.text = "Name : ${current.name}"
        holder.userDepartment.text = "Department : ${current.departmentName}"
    }

    internal fun updateAdapter(userDetail: List<UserDetail>) {
        this.userDetail = userDetail
        notifyDataSetChanged()
    }

    override fun getItemCount() = userDetail.size
}


