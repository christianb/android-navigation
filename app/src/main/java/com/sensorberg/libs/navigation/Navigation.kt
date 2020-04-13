package com.sensorberg.libs.navigation

import androidx.navigation.NavDirections

sealed class Navigation {
	object Up : Navigation()
	class Direction(val navDirections: NavDirections) : Navigation()
}