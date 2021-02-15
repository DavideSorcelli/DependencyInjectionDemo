package com.dsorcelli.dependencyinjectiondemo.repositories

interface HelloRepository {
    fun giveHello(): String
}

class HelloRepositoryImpl : HelloRepository {
    override fun giveHello() = "Hello Koin!"
}