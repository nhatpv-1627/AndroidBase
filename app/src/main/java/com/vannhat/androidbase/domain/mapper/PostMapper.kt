package com.vannhat.androidbase.domain.mapper

import com.vannhat.androidbase.data.model.PostData
import com.vannhat.androidbase.domain.entities.PostModel

class PostMapper : BaseMapper<PostData, PostModel>() {
    override fun map(data: PostData): PostModel {
        return PostModel(data.title, data.description, data.author, data.imgUrl, data.projectUrl)
    }
}
