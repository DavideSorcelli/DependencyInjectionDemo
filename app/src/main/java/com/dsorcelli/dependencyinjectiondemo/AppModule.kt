package com.dsorcelli.dependencyinjectiondemo

import com.dsorcelli.dependencyinjectiondemo.presenters.MySimplePresenter
import com.dsorcelli.dependencyinjectiondemo.repositories.HelloRepository
import com.dsorcelli.dependencyinjectiondemo.repositories.HelloRepositoryImpl
import org.koin.dsl.module

@JvmField
val appModule = module {

    // single instance of HelloRepository
    single<HelloRepository> { HelloRepositoryImpl() }

    // Simple Presenter Factory
    // new instance each time our Activity will need one
    factory { MySimplePresenter(get()) }

}