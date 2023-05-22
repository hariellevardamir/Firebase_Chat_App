package com.example.firebase_chat_app

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class AdminAdapter(
    val context: Context,

    val userList: ArrayList<User>,                         //
    //   val messageList: ArrayList<Message>
) :
    RecyclerView.Adapter<AdminAdapter.UserViewHolder>() {

    val ITEM_RECEIVE = 1
    val ITEM_SEND = 2

    /*
        private val differCallback = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.uid == newItem.uid

            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

        }

        val differ = AsyncListDiffer(this, differCallback)

    */

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName = itemView.findViewById<TextView>(R.id.txt_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.user_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
        //   return differ.currentList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {


        val currentUser = userList[position]
        holder.textName.text = currentUser.name
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ChatActivity::class.java)
            intent.putExtra("name", currentUser.name)
            intent.putExtra("uid", currentUser.uid)
            context.startActivity(intent)


            /*
             val currentUser = differ.currentList[position]
             holder.textName.text = currentUser.name
             holder.itemView.setOnClickListener {
                 val intent = Intent(context, ChatActivity::class.java)
                 intent.putExtra("name", currentUser.name)
                 intent.putExtra("uid", currentUser.uid)
                 context.startActivity(intent)


val currentUser = messageList[position]
        holder.textName.text = currentUser.message
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ChatActivity::class.java)
            intent.putExtra("name", "${currentUser.senderId}")
            //   intent.putExtra("uid", currentUser.uid)
            context.startActivity(intent)


v







            */

        }
    }
    /*
        override fun getItemViewType(position: Int): Int {
            val currentMessage = messageList[position]

            if (FirebaseAuth.getInstance().currentUser?.uid.equals(currentMessage.receiverId)) {
                messageList.add(currentMessage)
            }
            return ITEM_RECEIVE
        }

     */
}