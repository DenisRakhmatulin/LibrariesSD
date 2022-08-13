package com.sardavisgeekbrains.librariessd.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sardavisgeekbrains.librariessd.R
import com.sardavisgeekbrains.librariessd.details.OnClick
import com.sardavisgeekbrains.librariessd.model.GithubUser

class UserAdapter(private val onClick: OnClick) : RecyclerView.Adapter<GithubUserViewHolder>() {
    var users: List<GithubUser> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return GithubUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position])
        holder.itemView.setOnClickListener {
            onClick.sendData(users[position].login)
        }
    }

    override fun getItemCount() = users.size
}

class GithubUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvLogin by lazy { itemView.findViewById<TextView>(R.id.tvUserLogin) }

    fun bind(item: GithubUser) = with(item) {
        tvLogin.text = login
    }

}