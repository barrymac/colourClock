package colourtag

import grails.converters.JSON
import org.springframework.dao.DataIntegrityViolationException

import static javax.servlet.http.HttpServletResponse.*

class ColourController {

    static final int SC_UNPROCESSABLE_ENTITY = 422

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {}

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        response.setIntHeader('X-Pagination-Total', Colour.count())
        render Colour.list(params) as JSON
    }

    def save() {
        def colourInstance = new Colour(request.JSON)
        def responseJson = [:]
        if (colourInstance.save(flush: true)) {
            response.status = SC_CREATED
            responseJson.id = colourInstance.id
            responseJson.message = message(code: 'default.created.message', args: [message(code: 'colour.label', default: 'Colour'), colourInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = colourInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }
        render responseJson as JSON
    }

    def get() {
        def colourInstance = Colour.get(params.id)
        if (colourInstance) {
            render colourInstance as JSON
        } else {
            notFound params.id
        }
    }

    def tone() {
        def colours = Colour.findAllByTone(Tone.valueOf((params.id).toUpperCase()))
        if (colours) {
            render colours as JSON
        } else {
            notFound params.id
        }
    }

    def season() {
        def colours = Colour.findAllBySeason(Season.valueOf((params.id).toUpperCase()))
        if (colours) {
            render colours as JSON
        } else {
            notFound params.id
        }
    }

    def update() {
        def colourInstance = Colour.get(params.id)
        if (!colourInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]

        if (request.JSON.version != null) {
            if (colourInstance.version > request.JSON.version) {
                response.status = SC_CONFLICT
                responseJson.message = message(code: 'default.optimistic.locking.failure',
                        args: [message(code: 'colour.label', default: 'Colour')],
                        default: 'Another user has updated this Colour while you were editing')
                cache false
                render responseJson as JSON
                return
            }
        }

        colourInstance.properties = request.JSON

        if (colourInstance.save(flush: true)) {
            response.status = SC_OK
            responseJson.id = colourInstance.id
            responseJson.message = message(code: 'default.updated.message', args: [message(code: 'colour.label', default: 'Colour'), colourInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = colourInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }

        render responseJson as JSON
    }

    def delete() {
        def colourInstance = Colour.get(params.id)
        if (!colourInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]
        try {
            colourInstance.delete(flush: true)
            responseJson.message = message(code: 'default.deleted.message', args: [message(code: 'colour.label', default: 'Colour'), params.id])
        } catch (DataIntegrityViolationException e) {
            response.status = SC_CONFLICT
            responseJson.message = message(code: 'default.not.deleted.message', args: [message(code: 'colour.label', default: 'Colour'), params.id])
        }
        render responseJson as JSON
    }

    private void notFound(id) {
        response.status = SC_NOT_FOUND
        def responseJson = [message: message(code: 'default.not.found.message', args: [message(code: 'colour.label', default: 'Colour'), params.id])]
        render responseJson as JSON
    }
}
