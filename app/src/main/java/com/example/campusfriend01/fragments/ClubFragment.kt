package com.example.campusfriend01.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.campusfriend01.R
import com.example.campusfriend01.databinding.FragmentClubBinding

class ClubFragment : Fragment() {

    private lateinit var binding : FragmentClubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_club, container, false )

        binding.boardTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_clubFragment_to_boardFragment)
        }
        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_clubFragment_to_homeFragment)

        }
        binding.chatTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_clubFragment_to_chatFragment)

        }
        binding.settingTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_clubFragment_to_settingFragment)

        }

        return binding.root

    }
}