package com.example.googleplaystore.fragment

import android.media.RouteListingPreference.Item
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.googleplaystore.ItemAdapter
import com.example.googleplaystore.ItemApplication
import com.example.googleplaystore.databinding.FragmentForyouBinding

class ForYouFragment: Fragment() {
    private lateinit var bindding: FragmentForyouBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindding = FragmentForyouBinding.inflate(inflater, container, false)

        var listItem : ArrayList<ItemApplication> = ArrayList()
        for (n in 1..10){
            var item : ItemApplication = ItemApplication("app $n")
            listItem.add(item)
        }

        bindding.rcv.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        var adapter : ItemAdapter = activity?.let { ItemAdapter(listItem, it) }!!
        bindding.rcv.adapter = adapter

        bindding.rcvFlight.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        var adapter2 : ItemAdapter = activity?.let { ItemAdapter(listItem, it) }!!
        bindding.rcvFlight.adapter = adapter2

        bindding.rcvPopular.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        var adapter3 : ItemAdapter = activity?.let { ItemAdapter(listItem, it) }!!
        bindding.rcvPopular.adapter = adapter3
        return bindding.root
    }
}