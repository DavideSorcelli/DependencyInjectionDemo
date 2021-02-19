package com.dsorcelli.dependencyinjectiondemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dsorcelli.dependencyinjectiondemo.databinding.ActivityMainBinding
import com.dsorcelli.dependencyinjectiondemo.presenters.MySimplePresenter
import com.dsorcelli.dependencyinjectiondemo.viewmodels.MyViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val firstPresenter: MySimplePresenter by inject()

    /**
     * The "by viewModel()" function allows us to retrieve a ViewModel instance from Koin, linked to the Android ViewModelFactory.
     * The "getViewModel()" function is here to retrieve directly an instance (non lazy)
     */
    private val myViewModel: MyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lblPresenter.text = firstPresenter.sayHello()

        binding.lblViewmodel.text = myViewModel.sayHello()
    }

}