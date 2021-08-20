package com.reisdeveloper.introscreen.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reisdeveloper.introscreen.R
import com.reisdeveloper.introscreen.databinding.FragmentWalkthroughStepBinding
import com.reisdeveloper.introscreen.uimodel.LayoutUiModel

class WalkthroughStepFragment : Fragment() {

    private lateinit var binding: FragmentWalkthroughStepBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWalkthroughStepBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getInt("step")?.let {
            setViews(it)
        }
    }

    private fun setViews(step: Int) {
        val layout = layoutList()[step]

        binding.animationView.setAnimation(layout.animation)
        binding.title.text = requireContext().getString(layout.title)
        binding.description.text = requireContext().getString(layout.description)
    }

    private fun layoutList(): List<LayoutUiModel> =
        listOf(
            LayoutUiModel(
                R.raw.work_at_home,
                R.string.work_at_home,
                R.string.work_at_home_description
            ),
            LayoutUiModel(
                R.raw.deliverame_app,
                R.string.metrics,
                R.string.metrics_description
            ),
            LayoutUiModel(
                R.raw.rocket_launch,
                R.string.rocket,
                R.string.rocket_description
            )
        )

    companion object {
        fun newInstance(step: Int) =
            WalkthroughStepFragment().apply {
                arguments = Bundle().apply {
                    putInt("step", step)
                }
            }
    }

}