package com.example.game16

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatButton
import com.example.game16.databinding.ActivityMainBinding
import com.example.game16.utils.onBackClicked
import java.util.ArrayList


class MainActivity : AppCompatActivity(){
     // lateinit var binding : ActivityMainBinding
//    var emptyPosition = 15
//    var counter = 1
//    var isPlaying = false
//    var isresume = false
//    var start = true
//    var clickable  = true
//    lateinit var numbers : ArrayList<Int>
//    lateinit var btn : List<AppCompatButton>
//    lateinit var animator : ObjectAnimator
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
         //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    //binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(R.layout.activity_main)
}

//    override fun onBackPressed() {
//        super.onBackPressed()
//        finish()
//    }







//
//        btn = arrayListOf<AppCompatButton>(
//            binding.btn1,binding.btn2,binding.btn3,
//            binding.btn4,binding.btn5,binding.btn6,
//            binding.btn7,binding.btn8,binding.btn9,
//            binding.btn10,binding.btn11,binding.btn12,
//            binding.btn13,binding.btn14,binding.btn15
//        )
//
//        numbers = arrayListOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
//
//        for (i in 0 until 15){
//            btn[i].tag = i
//            btn[i].setOnClickListener(this)
//        }
//
//        shuffle()
//
//
//
//
//        binding.appCompatButton2.setOnClickListener{
//            if (start) started(start)
//            else if (isPlaying)  paused(isPlaying)
//            else if (isresume) resume(isresume)
//        }
//
//        binding.appCompatButton.setOnClickListener {
//
//
//
//
//        }
//
//
//    }
//
//    private fun shuffle (){
//        numbers
//        for (i in 0 until btn.size){
//            btn[i].text = numbers[i].toString()
//        }
//    }
//
//    override fun onClick(clicked: View) {
//        if (clickable){
//            started(start)
//            binding.textView.text = "Step : ${counter++}"
//            var pos = Integer.parseInt(clicked.tag.toString())
//            //Toast.makeText(this, clicked.tag.toString(), Toast.LENGTH_SHORT).show()
//            if (emptyPosition - pos == 1 && emptyPosition % 4 != 0) {
//                clicked.tag = emptyPosition
//                emptyPosition = pos
//                startAnim(clicked, "x", clicked.x + (clicked.width+18))
//            } else if (emptyPosition - pos == -1 && pos % 4 != 0) {
//                clicked.tag = emptyPosition
//                emptyPosition = pos
//                startAnim(clicked, "x", clicked.x - (clicked.width+18))
//            } else if (emptyPosition - pos == 4) {
//                clicked.tag = emptyPosition
//                emptyPosition = pos
//                startAnim(clicked, "y", clicked.y + (clicked.height+18))
//            } else if (emptyPosition - pos == -4) {
//                clicked.tag = emptyPosition
//                emptyPosition = pos
//                startAnim(clicked, "y", clicked.y - (clicked.height+18))
//            }
//            isWin()
//        }
//    }
//
//    private fun startAnim(view : View , property : String , value :Float ){
//        animator = ObjectAnimator.ofFloat(view ,property,value)
//        animator.duration = 150
//        animator.addListener(object : Animator.AnimatorListener{
//            override fun onAnimationStart(animation: Animator?) {
//                clickable = false
//            }
//
//            override fun onAnimationEnd(animation: Animator?) {
//                clickable = true
//            }
//
//            override fun onAnimationCancel(animation: Animator?) {
//
//            }
//
//            override fun onAnimationRepeat(animation: Animator?) {
//
//
//            }
//
//        })
//        animator.start()
//    }
//
//    private fun isWin(){
//        btn.forEach {
//            if (Integer.parseInt(it.tag.toString()) != Integer.parseInt(it.text.toString())-1){
//                return
//            }
//        }
//        Toast.makeText(this, "You win", Toast.LENGTH_SHORT).show()
//        binding.textView.text = "Step : 0"
//        counter = 0
//        binding.chronometer2.base = SystemClock.elapsedRealtime() + 0
//        binding.chronometer2.stop()
//        binding.appCompatButton2.setText("Start")
//        start = true
//    }
//
//    var oldTime = 0L
//
//
//    private fun started(start : Boolean){
//        if (start) {
//            this.start = false
//            binding.chronometer2.base = SystemClock.elapsedRealtime() + 0
//            binding.chronometer2.start()
//            binding.chronometer2.isFocusable = true
//            binding.appCompatButton2.setText("Pause")
//            this.isPlaying = true
//        }
//    }
//
//    private fun paused(isplay : Boolean){
//        if (isplay){
//            this.isPlaying = false
//            oldTime = binding.chronometer2.base - SystemClock.elapsedRealtime()
//            binding.chronometer2.stop()
//            binding.appCompatButton2.text = "Resume"
//            this.isresume = true
//            binding.pause.visibility = View.VISIBLE
//            clickable = false
//        }
//    }
//
//    private fun resume(isRes : Boolean){
//            if (isRes){
//                this.isresume = false
//                binding.chronometer2.base = SystemClock.elapsedRealtime() + oldTime
//                binding.chronometer2.start()
//                binding.appCompatButton2.text = "Pause"
//                this.isPlaying = true
//                binding.pause.visibility = View.INVISIBLE
//                clickable = true
//            }
//        }
//      lateinit  var onBackClicked : onBackClicked
//
//    override fun onDestroy() {
//        super.onDestroy()
//         onBackClicked.onClick()
//
//    }



    }




