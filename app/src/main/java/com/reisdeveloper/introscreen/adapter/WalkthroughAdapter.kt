package com.reisdeveloper.introscreen.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.reisdeveloper.introscreen.fragment.WalkthroughStepFragment

class WalkthroughAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = WalkthroughStepFragment.newInstance(position)
}