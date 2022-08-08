package com.example.dojoinnews.data.mapper

import com.example.dojoinnews.data.dto.NewsDTO
import com.example.dojoinnews.data.local.entity.NewsEntity
import com.example.dojoinnews.domain.model.News

fun NewsDTO.toNewEntity(): NewsEntity =
    NewsEntity(
        id = id,
        title = title,
        image = media.first().mediaMetadata.last().url,
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

