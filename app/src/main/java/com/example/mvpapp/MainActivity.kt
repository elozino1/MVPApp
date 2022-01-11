package com.example.mvpapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity(), MainActivityContract.View {
    // creating object of TextView class
    private var imageView: ImageView? = null

    // creating object of Button class
    private var button: Button? = null

    // creating object of ProgressBar class
    private var progressBar: ProgressBar? = null

    // creating object of Presenter interface in Contract
    var presenter: Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assigning ID of the TextView
        imageView = findViewById(R.id.iv_image)

        // assigning ID of the Button
        button = findViewById(R.id.button)

        // assigning ID of the ProgressBar
        progressBar = findViewById(R.id.progressBar)

        // instantiating object of Presenter Interface
        presenter = Presenter(this, Model())

        // operations to be performed when
        // user clicks the button
        this.button!!.setOnClickListener(View.OnClickListener { presenter!!.onButtonClick() })
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }

    // method to display the Course Detail TextView
    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
        imageView!!.visibility = View.INVISIBLE
    }

    // method to hide the Course Detail TextView
    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
        imageView!!.visibility = View.VISIBLE
    }

    // method to set random string
    // in the Course Detail TextView
    override fun loadImage(string: String?) {
        Glide.with(this).load(string).into(imageView!!)
    }
}

