package com.example.game16.fragmets

import android.animation.Animator
import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.os.SystemClock
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.game16.R
import com.example.game16.data_base_helper.DBhelper
import com.example.game16.databinding.CustomViewBinding
import com.example.game16.databinding.FragmentGameScreenBinding
import com.example.game16.databinding.FragmentHardLevelBinding
import com.example.game16.databinding.PauseDialogBinding
import com.example.game16.models.Score
import java.util.ArrayList

class HardLevelFragment : Fragment() ,View.OnClickListener {


    lateinit var binding : FragmentHardLevelBinding
    var emptyPosition = 24
    var counter = 1
    var isPlaying = false
    var isresume = false
    var start = true
    var number = 0
    var clickable  = true
    lateinit var numbers : ArrayList<Int>
    lateinit var btn : List<AppCompatButton>
    lateinit var animator : ObjectAnimator
    lateinit var mContext: Context



    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hard_level, container, false)
        binding = FragmentHardLevelBinding.bind(view)
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.def)
        btn = arrayListOf<AppCompatButton>(
            binding.btn1,binding.btn2,binding.btn3,
            binding.btn4,binding.btn5,binding.btn6,
            binding.btn7,binding.btn8,binding.btn9,
            binding.btn10,binding.btn11,binding.btn12,
            binding.btn13,binding.btn14,binding.btn15,
            binding.btn16,binding.btn17,binding.btn18,
            binding.btn19,binding.btn20,binding.btn21,
            binding.btn22,binding.btn23,binding.btn24
        )

        numbers = arrayListOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24)

        for (i in 0 until 24){
            btn[i].tag = i
            btn[i].setOnClickListener(this)
        }

        shuffle()





        binding.appCompatButton2.setOnClickListener{
            if (start) started(start)
            else if (isPlaying)  paused(isPlaying)
            else if (isresume) resume(isresume)
        }

        binding.appCompatButton.setOnClickListener {
            activity?.onBackPressed()
            findNavController().navigate(R.id.action_levelsFragment_to_hardLevelFragment)



        }

        return view
    }

    private fun shuffle (){
        numbers.shuffle()
        for (i in 0 until btn.size){
            btn[i].text = numbers[i].toString()
        }
    }

    override fun onClick(clicked: View) {
        if (clickable){
            started(start)

            number = counter
            var pos = Integer.parseInt(clicked.tag.toString())
            //Toast.makeText(this, clicked.tag.toString(), Toast.LENGTH_SHORT).show()
            if (emptyPosition - pos == 1 && emptyPosition % 5 != 0) {
                clicked.tag = emptyPosition
                emptyPosition = pos
                binding.textView.text = "Step : ${counter++}"
                startAnim(clicked, "x", clicked.x + (clicked.width+convertDpToPixel(4f,mContext)))
            } else if (emptyPosition - pos == -1 && pos % 5 != 0) {
                clicked.tag = emptyPosition
                emptyPosition = pos
                binding.textView.text = "Step : ${counter++}"
                startAnim(clicked, "x", clicked.x - (clicked.width+convertDpToPixel(4f,mContext)))
            } else if (emptyPosition - pos == 5) {
                clicked.tag = emptyPosition
                emptyPosition = pos
                binding.textView.text = "Step : ${counter++}"
                startAnim(clicked, "y", clicked.y + (clicked.height+convertDpToPixel(4f,mContext)))
            } else if (emptyPosition - pos == -5) {
                clicked.tag = emptyPosition
                emptyPosition = pos
                binding.textView.text = "Step : ${counter++}"
                startAnim(clicked, "y", clicked.y - (clicked.height+convertDpToPixel(4f,mContext)))
            }
            isWin()
        }
    }
    private fun startAnim(view : View , property : String , value :Float ){
        animator = ObjectAnimator.ofFloat(view ,property,value)
        animator.duration = 150
        animator.addListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {
                clickable = false
            }

            override fun onAnimationEnd(animation: Animator?) {
                clickable = true
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationRepeat(animation: Animator?) {


            }

        })
        animator.start()
    }

    private fun isWin(){
        btn.forEach {
            if (Integer.parseInt(it.tag.toString()) != Integer.parseInt(it.text.toString())-1){
                return
            }
        }
        var dialog = AlertDialog.Builder(mContext)
        val customView = View.inflate(mContext , R.layout.custom_view , null)

        dialog.setView(customView)
        var customBind = CustomViewBinding.bind(customView)
        var build = dialog.create()
        build.window?.setBackgroundDrawableResource(android.R.color.transparent)
        build.show()
        var database = DBhelper(mContext)
        var text = ""
        binding.apply {
            var chrono = chronometer2.base - SystemClock.elapsedRealtime()
            chronometer2.stop()
            chronometer2.base = SystemClock.elapsedRealtime() + chrono
            chronometer2.start()
            text = this.chronometer2.text.toString()
            chronometer2.stop()
        }
//        var chrono = binding.chronometer2.base - SystemClock.elapsedRealtime()
//        binding.chronometer2.stop()
//        binding.chronometer2.base = SystemClock.elapsedRealtime() + chrono
//        binding.chronometer2.start()
//        var text  = binding.chronometer2.text
//        binding.chronometer2.stop()


        customBind.appCompatButton3.setOnClickListener {
            var name = "player"
            if (customBind.editText.text?.trim()?.isNotEmpty() == true){
                name = customBind.editText.text.toString().trim()
            }
            var step = number


//}
            var obj = Score(name,step, text.toString() , "Hard")
            database.addRecord(obj)
            build.dismiss()
        }

        binding.textView.text = "Step : 0"
        counter = 0
        binding.chronometer2.base = SystemClock.elapsedRealtime() + 0
        binding.chronometer2.stop()
        binding.appCompatButton2.setText("Start")
        start = true
    }

    var oldTime = 0L


    private fun started(start : Boolean){
        if (start) {
            this.start = false
            binding.chronometer2.base = SystemClock.elapsedRealtime() + 0
            binding.chronometer2.start()
            binding.chronometer2.isFocusable = true
            binding.appCompatButton2.setText("Pause")
            this.isPlaying = true
        }
    }

    private fun paused(isplay : Boolean){
        if (isplay){
            this.isPlaying = false
            oldTime = binding.chronometer2.base - SystemClock.elapsedRealtime()
            binding.chronometer2.stop()
            binding.appCompatButton2.text = "Resume"
            this.isresume = true
            //binding.pause.visibility = View.VISIBLE
            clickable = false
            var pauseDialog = AlertDialog.Builder(mContext)
            var pView = View.inflate(mContext,R.layout.pause_dialog , null)
            var pauseBind = PauseDialogBinding.bind(pView)
            pauseDialog.setView(pView)
            var paBuild = pauseDialog.create()
            paBuild.window?.setBackgroundDrawableResource(android.R.color.transparent)
            paBuild.setCancelable(false)
            paBuild.show()

            pauseBind.appCompatButton3.setOnClickListener {
                resume(this.isresume)
                paBuild.dismiss()
            }



        }
    }

    private fun resume(isRes : Boolean){
        if (isRes){
            this.isresume = false
            binding.chronometer2.base = SystemClock.elapsedRealtime() + oldTime
            binding.chronometer2.start()
            binding.appCompatButton2.text = "Pause"
            this.isPlaying = true
            //binding.pause.visibility = View.INVISIBLE
            clickable = true
        }
    }

    fun convertDpToPixel(dp: Float, context: Context): Float {
        return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }



}