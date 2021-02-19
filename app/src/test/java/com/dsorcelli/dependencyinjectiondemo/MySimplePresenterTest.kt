package com.dsorcelli.dependencyinjectiondemo

import com.dsorcelli.dependencyinjectiondemo.presenters.MySimplePresenter
import com.dsorcelli.dependencyinjectiondemo.repositories.HelloRepository
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.koin.core.logger.Level
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.get
import org.koin.test.inject
import org.koin.test.mock.MockProviderRule
import org.koin.test.mock.declareMock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class MySimplePresenterTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger(Level.ERROR)
        modules(appModule)
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Mockito.mock(clazz.java)
    }

    private val presenter: MySimplePresenter by inject()

    @Test
    fun sayHello() {
        assertTrue(presenter.sayHello() == "Hello Koin!")
    }

    @Test
    fun sayHelloWithMock() {

        val mock = declareMock<HelloRepository>()

        // retrieve actual presenter (injected with mock)
        val presenter = get<MySimplePresenter>()
        presenter.sayHello()

        verify(mock, times(1)).giveHello()
    }

}