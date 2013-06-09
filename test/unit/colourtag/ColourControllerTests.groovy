package colourtag

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(ColourController)
@Mock(Colour)
class ColourControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/colour/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.colourInstanceList.size() == 0
        assert model.colourInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.colourInstance != null
    }

    void testSave() {
        controller.save()

        assert model.colourInstance != null
        assert view == '/colour/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/colour/show/1'
        assert controller.flash.message != null
        assert Colour.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/colour/list'

        populateValidParams(params)
        def colour = new Colour(params)

        assert colour.save() != null

        params.id = colour.id

        def model = controller.show()

        assert model.colourInstance == colour
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/colour/list'

        populateValidParams(params)
        def colour = new Colour(params)

        assert colour.save() != null

        params.id = colour.id

        def model = controller.edit()

        assert model.colourInstance == colour
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/colour/list'

        response.reset()

        populateValidParams(params)
        def colour = new Colour(params)

        assert colour.save() != null

        // test invalid parameters in update
        params.id = colour.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/colour/edit"
        assert model.colourInstance != null

        colour.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/colour/show/$colour.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        colour.clearErrors()

        populateValidParams(params)
        params.id = colour.id
        params.version = -1
        controller.update()

        assert view == "/colour/edit"
        assert model.colourInstance != null
        assert model.colourInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/colour/list'

        response.reset()

        populateValidParams(params)
        def colour = new Colour(params)

        assert colour.save() != null
        assert Colour.count() == 1

        params.id = colour.id

        controller.delete()

        assert Colour.count() == 0
        assert Colour.get(colour.id) == null
        assert response.redirectedUrl == '/colour/list'
    }
}
