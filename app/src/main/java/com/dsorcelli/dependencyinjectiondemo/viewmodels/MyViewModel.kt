package com.dsorcelli.dependencyinjectiondemo.viewmodels

import androidx.lifecycle.ViewModel
import com.dsorcelli.dependencyinjectiondemo.repositories.HelloRepository

class MyViewModel(private val repo: HelloRepository) : ViewModel() {

    fun sayHello() = "${repo.giveHello()} from $this"

}