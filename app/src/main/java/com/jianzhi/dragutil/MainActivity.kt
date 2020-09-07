package com.jianzhi.dragutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.jianzhi.jzgragutil.DragUtil
import com.jianzhi.jzgragutil.callback
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rootview = findViewById<View>(android.R.id.content).rootView

//        DragUtil(rootview.imageView, 1, rootview, rootview.imageView2,
//            object : callback {
//                override fun isOverLapping(a: Boolean) {
//                  if(a){
//                      rootview.imageView.background=resources.getDrawable(R.mipmap.background1)
//                  }else{
//                      rootview.imageView.background=resources.getDrawable(R.mipmap.backgroung2)
//                  }
//                }
//            })
    }
}