package com.liceo.liceochat.data.network.dto
 
import com.liceo.liceochat.data.local.MessageEntity
import com.liceo.liceochat.domain.Message
 
fun MessageDto.toDomain(): Message = Message(
    id = id ?: "",
    sender = sender ?: "Unknown",
    text = text ?: "",
    createdAt = createdAt ?: 0L
)
 
fun List<MessageDto>.toDomain(): List<Message> =
    map { it.toDomain() }

fun Message.toEntity(): MessageEntity = MessageEntity(
    id = id,
    sender = sender,
    text = text,
    createdAt = createdAt
)

fun MessageEntity.toDomain(): Message = Message(
    id = id,
    sender = sender,
    text = text,
    createdAt = createdAt
)
