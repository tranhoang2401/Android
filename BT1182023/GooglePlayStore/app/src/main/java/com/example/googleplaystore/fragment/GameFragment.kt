package com.example.googleplaystore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.googleplaystore.databinding.FragmentGameBinding

class GameFragment : Fragment(){
    private lateinit var bindding: FragmentGameBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindding = FragmentGameBinding.inflate(inflater, container, false)
        return bindding.root
    }
}