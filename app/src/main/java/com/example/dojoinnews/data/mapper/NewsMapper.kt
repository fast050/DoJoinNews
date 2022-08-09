package com.example.dojoinnews.data.mapper

import com.example.dojoinnews.data.local.entity.NewsEntity
import com.example.dojoinnews.data.remote.dto.Result
import com.example.dojoinnews.data.utils.Constants
import com.example.dojoinnews.domain.model.News

fun Result.toNewEntity(): NewsEntity =
    NewsEntity(
        id = id,
        title = title,
        image = media?.firstOrNull()?.media_metadata?.lastOrNull()?.url ?: Constants.placeHolderImageUrl,
        newsBy = byline,
        publishedDate = published_date,
        url = url,
        subject = abstract,
        source = source
    )

fun NewsEntity.toNews(): News =
    News(
        title = title,
        image = image,
        newsBy = newsBy,
        publishedDate = publishedDate,
        url = url,
        subject = subject,
        source = source
    )

