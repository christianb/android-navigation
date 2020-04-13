package com.sensorberg.libs.navigation

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class ControllableLifeCycle : LifecycleOwner {

	private val registry: LifecycleRegistry = LifecycleRegistry(this)

	init {
		registry.currentState = Lifecycle.State.INITIALIZED
	}

	fun setState(state: Lifecycle.State) {
		registry.currentState = state
	}

	override fun getLifecycle(): Lifecycle {
		return registry
	}
}