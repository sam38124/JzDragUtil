package com.jianzhi.jzgragutil

import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener

class DragUtil(
    var v: View,
    var changeView: View,
    var rootView: View,
    var delay: Long = 0,
    var overLappCallback: callback
) {
    var start = true

    /**
     * 拖动View方法
     *
     * @param v     view
     * @param delay 延迟
     */
    init {
        v.setOnClickListener { }
        v.setOnTouchListener(TouchListener())
    }

    inner class TouchListener : OnTouchListener {
        private var downX = 0f
        private var downY = 0f
        private var downTime: Long = 0
        var originalX = changeView.x
        var originalY = changeView.y
        var originalx = v.x
        var originaly = v.y
        var overLapp = false
        var originalWidth = 0
        var originalHeight = 0
        override fun onTouch(v: View, event: MotionEvent): Boolean {
            if (!start) {
                return false
            }
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    originalWidth = v.width
                    originalHeight = v.height
                    originalX = changeView.x
                    originalY = changeView.y
                    downX = event.x
                    downY = event.y
                    originalx = v.x
                    originaly = v.y
                    downTime = System.currentTimeMillis()
                }
                MotionEvent.ACTION_MOVE -> if (System.currentTimeMillis() - downTime >= delay) {
                    val xDistance = event.x - downX
                    val yDistance = event.y - downY
                    if (xDistance != 0f && yDistance != 0f) {
                        val l = (v.left + xDistance)
                        val r = (v.right + xDistance)
                        val t = (v.top + yDistance)
                        val b = (v.bottom + yDistance)
                        Log.e("TouchListener", "L->$l R->$r T->$t B->$b")
                        v.layout(l.toInt(), t.toInt(), r.toInt(), b.toInt())
                        if (v.x < rootView.x) {
                            v.x = rootView.x
                        }
                        if (v.y < rootView.y) {
                            v.y = rootView.y
                        }
                        if ((v.x + v.width) > (rootView.x + rootView.width)) {
                            v.x = ((rootView.width - v.width).toFloat())
                        }
                        if ((v.y + v.height) > (rootView.y + rootView.height)) {
                            v.y = ((rootView.height - v.height).toFloat())
                        }
                    }
                    val nowOverLapp = isOverLapping(
                        v.x,
                        v.y,
                        v.width,
                        v.height,
                        changeView.x,
                        changeView.y,
                        changeView.width,
                        changeView.height
                    )
                    if (overLapp != nowOverLapp) {
                        overLapp = nowOverLapp
                        overLappCallback.isOverLapping(overLapp)
                    }

                }
                MotionEvent.ACTION_UP -> {
                    if (isOverLapping(
                            v.x,
                            v.y,
                            v.width,
                            v.height,
                            changeView.x,
                            changeView.y,
                            changeView.width,
                            changeView.height
                        )
                    ) {
                        v.x = originalX
                        v.y = originalY
                        changeView.x = originalx
                        changeView.y = originaly
                    } else {
                        v.x = originalx
                        v.y = originaly
                    }
                    v.layoutParams.width = originalWidth
                    v.layoutParams.height = originalHeight
                    overLapp = false
                    overLappCallback.isOverLapping(false)
                }
            }
            return false
        }
    }

    fun isOverLapping(
        x1: Float, y1: Float, width1: Int,
        height1: Int, x2: Float, y2: Float, width2: Int, height2: Int
    ): Boolean {
        if (x1 <= x2 && x1 + width1 <= x2) {
            return false
        } else if (x2 <= x1 && x2 + width2 <= x1) {
            return false
        } else if (y1 <= y2 && y1 + height1 <= y2) {
            return false
        } else if (y2 <= y1 && y2 + height2 <= y1) {
            return false
        }
        return true
    }

    fun remove() {
        start = false
    }

    fun start() {
        start = true
    }
}

interface callback {
    fun isOverLapping(a: Boolean)
}

