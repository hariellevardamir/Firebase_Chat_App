package com.example.firebase_chat_app

class Message {
    var message: String? = null
    var senderId: String? = null
    var receiverId: String? = null


    constructor() {}

    constructor(message: String?, senderId: String?, receiverId: String?) {
        this.message = message
        this.senderId = senderId
        this.receiverId = receiverId
    }
}