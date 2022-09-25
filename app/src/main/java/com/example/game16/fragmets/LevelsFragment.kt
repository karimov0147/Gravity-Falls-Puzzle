package com.example.game16.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.game16.R
import com.example.game16.databinding.FragmentLevelsBinding


class LevelsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.def2)

        val view = inflater.inflate(R.layout.fragment_levels, container, false)
        val binding = FragmentLevelsBinding.bind(view)
        binding.apply {
            easy.setOnClickListener {
                findNavController().navigate(R.id.action_levelsFragment_to_easyLevelFragment)
            }
            medium.setOnClickListener {
                findNavController().navigate(R.id.action_levelsFragment_to_gameScreen)
            }
            hard.setOnClickListener {
                findNavController().navigate(R.id.action_levelsFragment_to_hardLevelFragment)
            }
        }



        return view
    }
}