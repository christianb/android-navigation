package com.sensorberg.libs.navigation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import com.sensorberg.libs.event.Event

internal class NavigatorImpl : Navigator {
    private val liveData = MutableLiveData<Event<Navigation>>()

    override fun up() {
        liveData.value = Event(Navigation.Up)
    }

    override fun to(navDirections: NavDirections) {
        liveData.value = Event(Navigation.Direction(navDirections))
    }

    override fun observe(
        owner: LifecycleOwner,
        observer: Observer<Event<Navigation>>
    ) {
        liveData.observe(owner, observer)
    }
}