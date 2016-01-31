package pl.ghostbuster.tumblrexplorer.common

import de.greenrobot.event.EventBus

object Bus {

    fun yell(event: Event) {
        EventBus.getDefault().post(event)
    }

    fun getIn(passenger: Passenger) {
        EventBus.getDefault().register(passenger)
    }

    fun getOut(passenger: Passenger) {
        EventBus.getDefault().unregister(passenger)
    }

    interface Event
    interface Passenger
}