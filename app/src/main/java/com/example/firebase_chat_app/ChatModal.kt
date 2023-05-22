package com.example.firebase_chat_app

class ChatModal {
    var receiver: String? = null
    var message: String? = null
    var docID: String? = null

    constructor() {}

    constructor(receiver: String?, message: String?, docId: String?) {
        this.receiver = receiver
        this.message = message
        this.docID = docId
    }

}