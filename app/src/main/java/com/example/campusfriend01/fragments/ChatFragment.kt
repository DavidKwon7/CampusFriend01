package com.example.campusfriend01.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.campusfriend01.R
import com.example.campusfriend01.chat.ChatRoomActivity
import com.example.campusfriend01.chat.User
import com.example.campusfriend01.chat.UserAdapter
import com.example.campusfriend01.databinding.FragmentChatBinding
import com.example.campusfriend01.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class ChatFragment : Fragment() {

    private lateinit var binding : FragmentChatBinding


    private val peopleDataList = mutableListOf<User>()
    private val peopleKeyList = mutableListOf<String>()

    private val TAG = ChatFragment::class.java.simpleName

    private lateinit var peopleRVAdapter : UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false )

        //어뎁터 연결하기
        peopleRVAdapter = UserAdapter(peopleDataList)
        binding.userRecyclerView.adapter = peopleRVAdapter

        binding.userRecyclerView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(context, ChatRoomActivity::class.java)
            intent.putExtra("key", peopleKeyList[position])

            startActivity(intent)
        }



        binding.boardTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_chatFragment_to_boardFragment)
        }
        binding.clubTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_chatFragment_to_clubFragment)

        }
        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_chatFragment_to_homeFragment)

        }
        binding.settingTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_chatFragment_to_settingFragment)

        }

        getFBClubData()

        return binding.root
    }

    private fun getFBClubData() {
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                peopleDataList.clear()

                for (dataModel in dataSnapshot.children) {
                    Log.d(TAG, dataModel.toString())

                    dataModel.key

                    val item = dataModel.getValue(PeopleModel::class.java)
                    peopleDataList.add(item!!)
                    peopleKeyList.add(dataModel.key.toString())
                }

                peopleKeyList.reverse()
                peopleDataList.reverse()

                peopleRVAdapter.notifyDataSetChanged()

                Log.d(TAG, peopleDataList.toString())

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.chatRef.addValueEventListener(postListener)
    }


}



