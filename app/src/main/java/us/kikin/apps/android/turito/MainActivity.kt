package us.kikin.apps.android.turito

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import us.kikin.apps.android.turito.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setSupportActionBar(binding.toolbar)
        setContentView(view)
    }
}
