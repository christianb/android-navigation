package com.sensorberg.libs.navigation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import io.mockk.mockk
import org.assertj.core.api.Assertions.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationLiveDataTest {

	@get:Rule val instantExecutorRule = InstantTaskExecutorRule()

	private lateinit var classUnderTest: NavigationLiveData

	@Before
	fun setUp() {
		classUnderTest = NavigationLiveData()
	}

	@Test
	fun `should observe Navigation Up event`() {
		classUnderTest.up()

		var actual: Navigation? = null
		classUnderTest.observe(alwaysResumedLifeCycleOwnwer(), Observer {
			actual = it.getOrNull()
		})

		assertThat(actual).isEqualTo(Navigation.Up)
	}

	@Test
	fun `should observe Navigation Direction event`() {
		val expected: NavDirections = mockk()
		classUnderTest.to(expected)

		var actual: Navigation? = null
		classUnderTest.observe(alwaysResumedLifeCycleOwnwer(), Observer {
			actual = it.getOrNull()
		})

		assertThat(actual).isInstanceOf(Navigation.Direction::class.java)
		assertThat((actual as Navigation.Direction).navDirections).isEqualTo(expected)
	}

	private fun alwaysResumedLifeCycleOwnwer(): LifecycleOwner {
		return ControllableLifeCycle().apply { setState(Lifecycle.State.RESUMED) }
	}
}