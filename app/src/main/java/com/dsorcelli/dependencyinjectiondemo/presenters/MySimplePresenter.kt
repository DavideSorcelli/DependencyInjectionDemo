package com.dsorcelli.dependencyinjectiondemo.presenters

import com.dsorcelli.dependencyinjectiondemo.repositories.HelloRepository

/**
 * Hello Consumer
 */
class MySimplePresenter(
    private val repo: HelloRepository
) {

    fun sayHello() = "${repo.giveHello()} from $this"

}