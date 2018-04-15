package com.a1995.hellokotlin

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /*
    Int vars
     */
    private var counter: Int = 0
    private var actualColor: Int = 0;

    /*
    lateinit vars
     */
    private lateinit var layout:ConstraintLayout
    private lateinit var textView: TextView
    private lateinit var primaryButton: Button
    private lateinit var secondaryButton: Button
    private lateinit var colors: MutableList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        Load elements
         */
        layout = findViewById<ConstraintLayout>(R.id.main_layout) as ConstraintLayout
        textView = findViewById<TextView>(R.id.textview1) as TextView
        primaryButton = findViewById<Button>(R.id.button1) as Button
        secondaryButton = findViewById<Button>(R.id.button2) as Button

        /*
        Set default configuration
         */
        layout.setBackgroundColor(Color.WHITE)
        textView.setTextColor(Color.BLACK)

        /*
        Create the color list
         */
        colors = mutableListOf(Color.GRAY, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW, Color.CYAN)

        /*
        Set OnClick listeners
         */
        primaryButton.setOnClickListener(this)
        secondaryButton.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button1 ->
            {
                /*
                Counter
                 */
                counter += 1
                textView.text= counter.toString()

                /*
                Choose a new color
                 */
                var newColor = colors.get(Random().nextInt(colors.size))
                while(actualColor == newColor){
                    newColor = colors.get(Random().nextInt(colors.size))
                }
                actualColor = newColor;

                layout.setBackgroundColor(newColor);
            }
            R.id.button2 ->
            {
                /*
                Set default configuration
                 */
                counter = 0
                textView.text = getString(R.string.home_text)
                layout.setBackgroundColor(Color.WHITE)
            }
        }
    }
}
