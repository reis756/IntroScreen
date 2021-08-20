package com.reisdeveloper.introscreen.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.reisdeveloper.introscreen.R
import com.reisdeveloper.introscreen.adapter.WalkthroughAdapter
import com.reisdeveloper.introscreen.databinding.FragmentWalkthroughBinding
import java.text.FieldPosition

class WalkthroughFragment : Fragment() {

    private lateinit var binding: FragmentWalkthroughBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentWalkthroughBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragment = this

        binding.pager.adapter = WalkthroughAdapter(this)

        TabLayoutMediator(binding.pagerIndicator, binding.pager) {_,_ ->}.attach()

        binding.pagerIndicator.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let {
                    positionVerify(it)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
    }

    private fun positionVerify(position: Int) {
        when(position) {
            0 -> {
                binding.btnBack.visibility = View.GONE
                binding.btnNext.text = getString(R.string.next)
            }
            2 -> {
                binding.btnBack.visibility = View.VISIBLE
                binding.btnNext.text = getString(R.string.go)
            }
            else ->{
                binding.btnBack.visibility = View.VISIBLE
                binding.btnNext.text = getString(R.string.next)
            }
        }
    }

    fun back() {
        binding.pager.currentItem--

        positionVerify(binding.pager.currentItem)
    }

    fun next() {
        if (binding.pager.currentItem == 2)
            findNavController().navigate(R.id.action_walkthrough_to_home)
        else {
            positionVerify(binding.pager.currentItem)
            binding.pager.currentItem++
        }
    }
}











