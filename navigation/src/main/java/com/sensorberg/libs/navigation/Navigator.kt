package com.sensorberg.libs.navigation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import com.sensorberg.libs.event.Event

/**
 * Provides methods for navigation.
 */
interface Navigator {
    /**
     * Navigates up.
     */
    fun up()

    /**
     * Navigates to a given [NavDirections].
     */
    fun to(navDirections: NavDirections)

    /**
     * Observe for navigation events.
     * Navigation events can only be consumed once!
     */
    fun observe(
        lifecycleOwner: LifecycleOwner,
        observer: Observer<Event<Navigation>>
    )

    companion object {
        /**
         * Creates a new instance of [Navigator].
         */
        fun create(): Navigator = NavigatorImpl()
    }
}