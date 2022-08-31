package com.example.vibrationtest

import android.content.Context
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import com.example.vibrationtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get the VIBRATOR_SERVICE system service
        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager =
                getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator
        } else {
            @Suppress("DEPRECATION")
            getSystemService(VIBRATOR_SERVICE) as Vibrator
        }

        // handle normal vibration button
        binding.normalVibrationButton.setOnClickListener {

            val vibrationEffect1: VibrationEffect

            // this is the only type of the vibration which requires system version Oreo (API 26)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                // this effect creates the vibration of default amplitude for 10ms (0.01 sec)
                vibrationEffect1 =
                    VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE)

                // it is safe to cancel other vibrations currently taking place
                vibrator.cancel()
                vibrator.vibrate(vibrationEffect1)
            }

        }

        // handle click vibration button
        binding.clickVibrationButton.setOnClickListener {

            // this type of vibration requires API 29
            val vibrationEffect2: VibrationEffect
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // create vibrator effect with the constant EFFECT_CLICK
                vibrationEffect2 = VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK)

                // it is safe to cancel other vibrations currently taking place
                vibrator.cancel()
                vibrator.vibrate(vibrationEffect2)
            }

        }

        // handle double click vibration button
        binding.doubleClickVibrationButton.setOnClickListener {

            val vibrationEffect3: VibrationEffect

            // this type of vibration requires API 29
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // create vibrator effect with the constant EFFECT_DOUBLE_CLICK
                vibrationEffect3 =
                    VibrationEffect.createPredefined(VibrationEffect.EFFECT_DOUBLE_CLICK)

                // it is safe to cancel other vibrations currently taking place
                vibrator.cancel()
                vibrator.vibrate(vibrationEffect3)
            }

        }

        // handle tick effect vibration button
        binding.tickVibrationButton.setOnClickListener {

            val vibrationEffect4: VibrationEffect

            // this type of vibration requires API 29
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // create vibrator effect with the constant EFFECT_TICK
                vibrationEffect4 = VibrationEffect.createPredefined(VibrationEffect.EFFECT_TICK)

                // it is safe to cancel other vibrations currently taking place
                vibrator.cancel()
                vibrator.vibrate(vibrationEffect4)
            }

        }

        // handle heavy click vibration button
        binding.heavyClickVibrationButton.setOnClickListener {

            val vibrationEffect5: VibrationEffect

            // this type of vibration requires API 29
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // create vibrator effect with the constant EFFECT_HEAVY_CLICK
                vibrationEffect5 =
                    VibrationEffect.createPredefined(VibrationEffect.EFFECT_HEAVY_CLICK)

                // it is safe to cancel other vibrations currently taking place
                vibrator.cancel()
                vibrator.vibrate(vibrationEffect5)
            }

        }

    }
}
