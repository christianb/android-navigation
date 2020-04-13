package com.sensorberg.libs.navigation

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import timber.log.Timber

/**
 * Observes a [Navigator] from a [Navigationable] interface and executes navigation.
 */
fun Fragment.setupNavigation(navigationable: Navigationable) {
	navigationable.navigator.observe(viewLifecycleOwner, Observer {
		when (val navigation: Navigation? = it.getOrNull()) {
			Navigation.Up -> findNavController().navigateUp()
			is Navigation.Direction -> findNavController().navigate(navigation.navDirections)
			null -> Timber.w("The observed navigation event was either null or has been consumed!")
		}
	})
}