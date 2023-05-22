package com.example.firebase_chat_app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ChatsAdapter(val context: Context, private val chatList: ArrayList<ChatModal>) :
    RecyclerView.Adapter<ChatsAdapter.ChatsViewHolder>() {
    class ChatsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.txtReceiverName)
        val message: TextView = view.findViewById(R.id.txtMessage)
        val content: CardView = view.findViewById(R.id.chatContent)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChatsAdapter.ChatsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_view, parent, false)
        return ChatsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatsAdapter.ChatsViewHolder, position: Int) {
        val list = chatList[position]
        holder.name.text = list.receiver
        holder.message.text = list.message
        holder.content.setOnClickListener {
            val intent = Intent(context, ChatActivity::class.java).also {
                it.putExtra("OptionName", "chatMessaging")
                it.putExtra("chatroom", list.docID)
                it.putExtra("receiverName", list.receiver)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }


}