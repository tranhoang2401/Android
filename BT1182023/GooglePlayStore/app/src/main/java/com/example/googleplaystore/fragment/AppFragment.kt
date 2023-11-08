package com.example.googleplaystore.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.googleplaystore.databinding.FragmentAppBinding
import com.google.android.material.tabs.TabLayoutMediator

class AppFragment : Fragment() {
    private lateinit var binding: FragmentAppBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var fragmentAppAdapter: FragmentAppAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAppBinding.inflate(inflater, container, false)
        fragmentAppAdapter = activity?.let { FragmentAppAdapter(it) }!!
        viewPager = binding.vpgApp
        viewPager.adapter = fragmentAppAdapter
        val tabLayoutMediator = TabLayoutMediator(binding.tabApp, viewPager){
                tab, position ->
            when (position) {
                0 -> {
                    tab.text = "For you"
                }
                1 -> {
                    tab.text = "Top charts"
                }
                2 -> {
                    tab.text = "Other devices"
                }
            }
        }
        tabLayoutMediator.attach();
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                viewPager.isUserInputEnabled = false
            }
        })
        return binding.root

    }
}
class FragmentAppAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ForYouFragment()
            1 -> Fragment()
            2 -> Fragment()
            else -> {
                ForYouFragment()
            }
        }
    }
}
