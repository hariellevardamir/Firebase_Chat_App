package com.example.firebase_chat_app

class Admin {
    var name: String? = null
    var email: String? = null
    var uid: String? = null
    var isAdmin: Boolean? = null

    constructor() {}

    constructor(name: String?, email: String?, uid: String?, isAdmin: Boolean?) {
        this.name = name
        this.email = email
        this.uid = uid
        this.isAdmin = isAdmin
    }
}