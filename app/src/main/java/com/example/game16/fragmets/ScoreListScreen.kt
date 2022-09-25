package com.example.game16.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.plattysoft.leonids.ParticleSystem
import android.annotation.SuppressLint
import android.content.Context
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.game16.R
import com.example.game16.adapters.MyAdapter
import com.example.game16.data_base_helper.DBhelper
import com.example.game16.databinding.FragmentScoreListScreenBinding
import com.example.game16.models.Score


class ScoreListScreen : Fragment() {

    lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.def)
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_score_list_screen, container, false)
        var binding = FragmentScoreListScreenBinding.bind(view)
        var database = DBhelper(mContext)
        var array = database.getAllRecord()
        var arr = ArrayList<Score>()
        for (i in 0 until array.size) {
            arr.add(array[array.size-1-i])
        }
        if (arr.isEmpty()){
            binding.placeHolder.visibility = View.VISIBLE
        }
        binding.Rview.adapter = MyAdapter(arr)

        binding.button.setOnClickListener{
            activity?.onBackPressed()
        }

        binding.delete.setOnClickListener {
            database.deleteAll()
            binding.Rview.adapter = MyAdapter(arrayListOf())

        }


        return view
    }

}