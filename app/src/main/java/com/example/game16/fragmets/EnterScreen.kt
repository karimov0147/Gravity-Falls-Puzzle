package com.example.game16.fragmets

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.media.MediaParser
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.game16.R
import com.example.game16.databinding.FragmentEnterScreenBinding
import com.example.game16.utils.App
import com.example.game16.utils.Constant
import com.example.game16.utils.onBackClicked


class EnterScreen : Fragment() {

    lateinit var move : MediaPlayer
    lateinit var mContext :Context
    lateinit var binding : FragmentEnterScreenBinding

    var sis = "pause"
    var btn = "play"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        Constant.SharedPreferences1(mContext)
        move = MediaPlayer.create(context , R.raw.wwww)
    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.def2)


        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_enter_screen, container, false)
        binding = FragmentEnterScreenBinding.bind(view)

        move.isLooping = true

        if (sis.equals("pause")){
            binding.volumeBtn.setImageResource(R.drawable.ic_baseline_volume_off_24)

        }
        else if (sis.equals("play")){
            binding.volumeBtn.setImageResource(R.drawable.ic_baseline_volume_up_24)

        }

        binding.volumeBtn.setOnClickListener{

           if (btn == "play"){
               binding.volumeBtn.setImageResource(R.drawable.ic_baseline_volume_up_24)
               move.start()
               sis = "play"
               btn = "pause"
           }
           else if (btn == "pause"){
                   binding.volumeBtn.setImageResource(R.drawable.ic_baseline_volume_off_24)
                   move.pause()
                   sis = "pause"
                   btn = "play"
            }
        }







        binding.apply {
            startBtn.setOnClickListener {
                findNavController().navigate(R.id.action_enterScreen_to_levelsFragment)
            }
            scoreBtn.setOnClickListener {
                findNavController().navigate(R.id.action_enterScreen_to_scoreListScreen)
            }
            exitBtn.setOnClickListener {
                move.stop()
                activity?.finish()
            }
            infoBtn.setOnClickListener {
                findNavController().navigate(R.id.action_enterScreen_to_infoScreen)
            }
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        move.stop()
        activity?.finish()
    }


}