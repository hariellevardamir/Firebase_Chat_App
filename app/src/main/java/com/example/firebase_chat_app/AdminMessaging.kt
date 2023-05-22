package com.example.firebase_chat_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AdminMessaging : AppCompatActivity() {

    private lateinit var adminRecyclerView: RecyclerView
    private lateinit var userList: ArrayList<User>
    private lateinit var messageList: ArrayList<Message>
    private lateinit var adapter: AdminAdapter

    private lateinit var mDbRef: DatabaseReference
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_messaging)

        //  val paylasilanData = AdminMessaging.sharedData                                //777
        //   Log.d("TAG", "paylaşılan data : $paylasilanData")


        mAuth = FirebaseAuth.getInstance()
        mDbRef = FirebaseDatabase.getInstance().getReference()


        userList = ArrayList()
        messageList = ArrayList()

        adapter = AdminAdapter(this, userList)
        adminRecyclerView = findViewById(R.id.adminRecyclerView)
        adminRecyclerView.layoutManager = LinearLayoutManager(this)
        adminRecyclerView.adapter = adapter

        mDbRef.child("user").addValueEventListener(object : ValueEventListener {

            @SuppressLint("SuspiciousIndentation", "NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {

                userList.clear()

                for (postSnapshot in snapshot.children) {
                    val currentUser = postSnapshot.getValue(User::class.java)

                    Log.d("TAG", "MESAJ GELDİ3")

                    if (mAuth.currentUser?.uid != currentUser?.uid) {
                        Log.d("TAG", "MESAJ GELDİ")

                        //        if(message.receiverUid == currentUserUid){
                        Log.d("TAG", "MESAJ GELDİ2")
                        userList.add(currentUser!!)

                    }

                    Log.d("TAG", "MESAJ GELDİ4")

                }
                adapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.logout) {
            // write the login for logout
            mAuth.signOut()
            Intent(this, LogIn::class.java).also {
                finish()
                startActivity(it)
            }
            return true
        }
        return true
    }

}