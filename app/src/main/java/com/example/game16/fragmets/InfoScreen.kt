package com.example.game16.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.game16.R
import com.example.game16.databinding.FragmentInfoScreenBinding


class InfoScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_info_screen, container, false)
        var binding = FragmentInfoScreenBinding.bind(view)

        binding.button.setOnClickListener{
            activity?.onBackPressed()
        }

        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.def)



        return view
    }


}