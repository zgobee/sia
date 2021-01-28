package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class UsersAdapter (context: Context, users: ArrayList<user>) :
    ArrayAdapter<user>(context,0,users) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val user = getItem(position)
        val cv = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false)
        val nameTextView: TextView = cv.findViewById(R.id.Name)
        val profilePic: ImageView = cv.findViewById(R.id.ProfilePic)

        nameTextView.text = user?.name
        Glide.with(context)
            .load(user?.url)
            .placeholder(R.drawable.ic_launcher_background)
            .centerCrop()
            .into(profilePic)
        return cv

    }

}
