// Name: Renzo Salosagcol
// CWID: 884695503
// Email: renzosalosagcol@csu.fullerton.edu


package edu.fz.cs411.assignment3_colormaker

import android.graphics.Color
import android.graphics.Color.rgb
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import java.text.DecimalFormat
import kotlin.math.floor

class MainActivity : AppCompatActivity() {

    private lateinit var redSeekBar: SeekBar
    private lateinit var greenSeekBar: SeekBar
    private lateinit var blueSeekBar: SeekBar
    private lateinit var redSwitch: Switch
    private lateinit var greenSwitch: Switch
    private lateinit var blueSwitch: Switch
    private lateinit var resetButton: Button
    private lateinit var colorResult: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorResult = findViewById<LinearLayout>(R.id.colorResultView)
        val df = DecimalFormat("#.##")

        resetButton = findViewById<Button>(R.id.resetButton)

        redSwitch = findViewById<Switch>(R.id.redSwitch)
        greenSwitch = findViewById<Switch>(R.id.greenSwitch)
        blueSwitch = findViewById<Switch>(R.id.blueSwitch)

        redSeekBar = findViewById(R.id.redSeekBar)
        greenSeekBar = findViewById(R.id.greenSeekBar)
        blueSeekBar = findViewById(R.id.blueSeekBar)

        var redSeekBarValue: Double = 0.0
        var greenSeekBarValue: Double = 0.0
        var blueSeekBarValue: Double = 0.0

        redSwitch.text = "Value: $redSeekBarValue"
        greenSwitch.text = "Value: $greenSeekBarValue"
        blueSwitch.text = "Value: $blueSeekBarValue"

        redSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(redSeekBar: SeekBar?, seekBarValue: Int, user: Boolean) {
                newBackgroundColor()
                redSeekBarValue = seekBarValue.toDouble() / 255.0
                val formattedRedValue = df.format(redSeekBarValue)
                redSwitch.text = "Value: $formattedRedValue"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Pass
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //Pass
            }
        })

        greenSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(greenSeekBar: SeekBar?, seekBarValue: Int, user: Boolean) {
                newBackgroundColor()
                greenSeekBarValue = seekBarValue.toDouble() / 255.0
                val formattedGreenValue = df.format(greenSeekBarValue)
                greenSwitch.text = "Value: $formattedGreenValue"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Pass
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //Pass
            }
        })

        blueSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(blueSeekBar: SeekBar?, seekBarValue: Int, user: Boolean) {
                newBackgroundColor()
                blueSeekBarValue = seekBarValue.toDouble() / 255.0
                val formattedBlueValue = df.format(blueSeekBarValue)
                blueSwitch.text = "Value: $formattedBlueValue"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Pass
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //Pass
            }
        })

        redSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                newBackgroundColor()
            } else {
                newBackgroundColor()

            }
        }

        greenSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                newBackgroundColor()
            } else {
                newBackgroundColor()
            }
        }

        blueSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                newBackgroundColor()
            } else {
                newBackgroundColor()
            }
        }

        resetButton.setOnClickListener{
            redSwitch.isChecked = true
            greenSwitch.isChecked = true
            blueSwitch.isChecked = true

            redSeekBar.progress = 0
            greenSeekBar.progress = 0
            blueSeekBar.progress = 0

            newBackgroundColor()
        }
    }

    private fun newBackgroundColor()
    {
        val newBackgroundColor = Color.rgb(checkRedSwitch(), checkGreenSwitch(), checkBlueSwitch())
        colorResult.setBackgroundColor(newBackgroundColor)
    }

    private fun checkRedSwitch(): Int
    {
        if (redSwitch.isChecked == false)
            return 0
        else {
            return redSeekBar.progress
        }
    }

    private fun checkGreenSwitch(): Int
    {
        if (greenSwitch.isChecked == false)
            return 0
        else {
            return greenSeekBar.progress
        }
    }

    private fun checkBlueSwitch(): Int
    {
        if (blueSwitch.isChecked == false)
            return 0
        else {
            return blueSeekBar.progress
        }
    }
}