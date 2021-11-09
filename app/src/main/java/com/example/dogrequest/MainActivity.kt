package com.example.dogrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.core.net.toUri
import coil.load
import com.example.network.DogPhoto

class MainActivity : AppCompatActivity() {

    private val viewModel:DogsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getDogInfo()
        //1. Observe when the values of the photos changes
        //2. Update the UI when the values changes
        // call the viewModel, the external accessible photos value and then observe

        viewModel.currentDogImage.observe(this,
        //observing the specific value: photos //Whenever the value changes,
        { findViewById<ImageView>(R.id.imageView).load(

                    it.message?.toUri()?.buildUpon()?.scheme("https")?.build()
                    //sets the ImageView to load pics using the coil library/dependency
                )
            findViewById<Button>(R.id.button).setOnClickListener{
                viewModel.getDogInfo()
            }
        })

    }
}