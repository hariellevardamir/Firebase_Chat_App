package com.example.firebase_chat_app

object InfoData {
    fun getInfoData(): List<Admin> {
        var adminList = mutableListOf<Admin>()

        val admin1 = Admin("Avrupa", "avrupa@hotmail.com", "Ssv1HRtrIRXDG1xqjMTbGoJuuBr2", true)
        adminList.add(admin1)

        val admin2 = Admin("Anadolu", "anadolu@hotmail.com", "WqYQ7Mo8LMN9YZr0kcNwT8mIodH3", true)
        adminList.add(admin2)

        return adminList
    }
}