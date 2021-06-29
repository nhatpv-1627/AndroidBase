package com.vannhat.androidbase.domain.mapper

import com.vannhat.androidbase.data.model.PostData
import com.vannhat.androidbase.domain.entities.BlogModel
import com.vannhat.androidbase.domain.entities.PostModel

class BlogMapper : BaseMapper<PostData, BlogModel>() {
    override fun map(data: PostData): BlogModel {
        return BlogModel(data.title, data.description, data.author, data.imgUrl, data.projectUrl)
    }
}
