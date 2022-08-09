package com.example.dojoinnews.presentation.ui.utils

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dojoinnews.domain.model.News
import de.hdodenhof.circleimageview.CircleImageView

@SuppressLint("ResourceType")
@BindingAdapter("imageUrl")
fun loadImage(view: CircleImageView, url: String) =
    Glide.with(view.context).load(url).into(view)

@SuppressLint("ResourceType")
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) =
    Glide.with(view.context).load(url).into(view)