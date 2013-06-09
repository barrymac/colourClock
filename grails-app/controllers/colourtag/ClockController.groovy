package colourtag

import grails.converters.JSON
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import org.springframework.dao.DataIntegrityViolationException

import static javax.servlet.http.HttpServletResponse.*

class ClockController {

    static final int SC_UNPROCESSABLE_ENTITY = 422

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {}

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        response.setIntHeader('X-Pagination-Total', Clock.count())
        render Clock.list(params) as JSON
    }

    def save() {
        def clockInstance = new Clock(request.JSON)
        def responseJson = [:]
        if (clockInstance.save(flush: true)) {
            response.status = SC_CREATED
            responseJson.id = clockInstance.id
            responseJson.message = message(code: 'default.created.message', args: [message(code: 'clock.label', default: 'Clock'), clockInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = clockInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }
        render responseJson as JSON
    }

    def get() {
        def clockInstance = Clock.get(params.id)
        if (clockInstance) {
            def now = clockInstance.now
//            <YYYYYMMDDhhmmss>
            DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYYMMDDhhmmss");
//            String nowformat = "$now.year$now.mon"
            def clockMap = [mode: clockInstance.mode, name: clockInstance.name, utc: now, fmt: fmt.print(now)]
            render clockMap as JSON
//            render clockInstance.properties as JSON
        } else {
            notFound params.id
        }
    }

    def name() {
        def clockInstance = Clock.findByName(params.id)
        if (clockInstance) {
            def clockMap = [mode: clockInstance.mode, name: clockInstance.name, time: clockInstance.now]
            render clockMap as JSON
//			render clockInstance as JSON
        } else {
            notFound params.id
        }
    }

    def update() {
        def clockInstance = Clock.get(params.id)
        if (!clockInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]

        if (request.JSON.version != null) {
            if (clockInstance.version > request.JSON.version) {
                response.status = SC_CONFLICT
                responseJson.message = message(code: 'default.optimistic.locking.failure',
                        args: [message(code: 'clock.label', default: 'Clock')],
                        default: 'Another user has updated this Clock while you were editing')
                cache false
                render responseJson as JSON
                return
            }
        }

        clockInstance.properties = request.JSON

        if (clockInstance.save(flush: true)) {
            response.status = SC_OK
            responseJson.id = clockInstance.id
            responseJson.message = message(code: 'default.updated.message', args: [message(code: 'clock.label', default: 'Clock'), clockInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = clockInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }

        render responseJson as JSON
    }

    def delete() {
        def clockInstance = Clock.get(params.id)
        if (!clockInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]
        try {
            clockInstance.delete(flush: true)
            responseJson.message = message(code: 'default.deleted.message', args: [message(code: 'clock.label', default: 'Clock'), params.id])
        } catch (DataIntegrityViolationException e) {
            response.status = SC_CONFLICT
            responseJson.message = message(code: 'default.not.deleted.message', args: [message(code: 'clock.label', default: 'Clock'), params.id])
        }
        render responseJson as JSON
    }

    private void notFound(id) {
        response.status = SC_NOT_FOUND
        def responseJson = [message: message(code: 'default.not.found.message', args: [message(code: 'clock.label', default: 'Clock'), params.id])]
        render responseJson as JSON
    }
}
