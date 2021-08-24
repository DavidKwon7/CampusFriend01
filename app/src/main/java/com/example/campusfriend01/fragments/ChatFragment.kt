package com.example.campusfriend01.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.campusfriend01.R
import com.example.campusfriend01.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    private lateinit var binding : FragmentChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false )

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

        return binding.root
    }


}