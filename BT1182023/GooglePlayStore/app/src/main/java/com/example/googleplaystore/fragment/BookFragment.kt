package com.example.googleplaystore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.googleplaystore.databinding.FragmentBookBinding

class BookFragment : Fragment() {
    private lateinit var bindding: FragmentBookBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindding = FragmentBookBinding.inflate(inflater, container, false)
        return bindding.root
    }
}