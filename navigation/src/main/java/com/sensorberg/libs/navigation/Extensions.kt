package com.sensorberg.libs.navigation

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import timber.log.Timber

fun Fragment.setupNavigation(navigationable: Navigationable) {
	navigationable.navigationLiveData.observe(viewLifecycleOwner, Observer {
		when (val navigation: Navigation? = it.getOrNull()) {
			Navigation.Up -> findNavController().navigateUp()
			is Navigation.Direction -> findNavController().navigate(navigation.navDirections)
			null -> Timber.w("The observed navigation event was either null or has been consumed!")
		}
	})
}