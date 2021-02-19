package com.dsorcelli.dependencyinjectiondemo

import com.dsorcelli.dependencyinjectiondemo.presenters.MySimplePresenter
import com.dsorcelli.dependencyinjectiondemo.repositories.HelloRepository
import com.dsorcelli.dependencyinjectiondemo.repositories.HelloRepositoryImpl
import com.dsorcelli.dependencyinjectiondemo.viewmodels.MyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val appModule = module {

    // single instance of HelloRepository
    single<HelloRepository> { HelloRepositoryImpl() }

    // Simple Presenter Factory
    // new instance each time our Activity will need one
    factory { MySimplePresenter(get()) }

    // Koin will give a MyViewModel to the lifecycle ViewModelFactory
    // and help bind it to the current component
    viewModel { MyViewModel(get())}

}