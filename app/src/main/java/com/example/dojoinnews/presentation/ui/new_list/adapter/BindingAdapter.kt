package com.example.dojoinnews.presentation.ui.new_list.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dojoinnews.domain.model.News
import de.hdodenhof.circleimageview.CircleImageView

@SuppressLint("ResourceType")
@BindingAdapter("imageUrl")
fun loadImage(view: CircleImageView, url: String) =
    Glide.with(view.context).load(url).into(view)