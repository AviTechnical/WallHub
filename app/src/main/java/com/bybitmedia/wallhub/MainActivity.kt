package com.bybitmedia.wallhub

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.bybitmedia.wallhub.databinding.ActivityMainBinding
import com.bybitmedia.wallhub.Fragments.DownloadFragment
import com.bybitmedia.wallhub.Fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

            }
        binding.icHome.setOnClickListener {
            replaceFragment(HomeFragment())
        }

        

        binding.icDownload.setOnClickListener {
            replaceFragment(DownloadFragment())
        }
    }
    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentReplace, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(null)
        }

        transaction.commitAllowingStateLoss() // Avoids potential crashes if state loss is acceptable
    }

}



