package colourtag

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(ClockController)
@Mock(Clock)
class ClockControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/clock/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.clockInstanceList.size() == 0
        assert model.clockInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.clockInstance != null
    }

    void testSave() {
        controller.save()

        assert model.clockInstance != null
        assert view == '/clock/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/clock/show/1'
        assert controller.flash.message != null
        assert Clock.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/clock/list'

        populateValidParams(params)
        def clock = new Clock(params)

        assert clock.save() != null

        params.id = clock.id

        def model = controller.show()

        assert model.clockInstance == clock
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/clock/list'

        populateValidParams(params)
        def clock = new Clock(params)

        assert clock.save() != null

        params.id = clock.id

        def model = controller.edit()

        assert model.clockInstance == clock
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/clock/list'

        response.reset()

        populateValidParams(params)
        def clock = new Clock(params)

        assert clock.save() != null

        // test invalid parameters in update
        params.id = clock.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/clock/edit"
        assert model.clockInstance != null

        clock.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/clock/show/$clock.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        clock.clearErrors()

        populateValidParams(params)
        params.id = clock.id
        params.version = -1
        controller.update()

        assert view == "/clock/edit"
        assert model.clockInstance != null
        assert model.clockInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/clock/list'

        response.reset()

        populateValidParams(params)
        def clock = new Clock(params)

        assert clock.save() != null
        assert Clock.count() == 1

        params.id = clock.id

        controller.delete()

        assert Clock.count() == 0
        assert Clock.get(clock.id) == null
        assert response.redirectedUrl == '/clock/list'
    }
}
