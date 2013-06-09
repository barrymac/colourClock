package colourtag

import org.joda.time.DateTime


class Clock {

    DateTime now = new DateTime()
    String name
    String mode

    static transients = ['now']

    static constraints = {
    }

}
