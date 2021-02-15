package com.dsorcelli.dependencyinjectiondemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dsorcelli.dependencyinjectiondemo.databinding.ActivityMainBinding
import com.dsorcelli.dependencyinjectiondemo.presenters.MySimplePresenter
import org.koin.android.ext.android.inject
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val firstPresenter: MySimplePresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lblTest.text = firstPresenter.sayHello()
    }

}