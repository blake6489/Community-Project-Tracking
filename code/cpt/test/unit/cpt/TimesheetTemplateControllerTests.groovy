package cpt



import org.junit.*
import grails.test.mixin.*

@TestFor(TimesheetTemplateController)
@Mock(TimesheetTemplate)
class TimesheetTemplateControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/timesheetTemplate/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.timesheetTemplateInstanceList.size() == 0
        assert model.timesheetTemplateInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.timesheetTemplateInstance != null
    }

    void testSave() {
        controller.save()

        assert model.timesheetTemplateInstance != null
        assert view == '/timesheetTemplate/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/timesheetTemplate/show/1'
        assert controller.flash.message != null
        assert TimesheetTemplate.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/timesheetTemplate/list'


        populateValidParams(params)
        def timesheetTemplate = new TimesheetTemplate(params)

        assert timesheetTemplate.save() != null

        params.id = timesheetTemplate.id

        def model = controller.show()

        assert model.timesheetTemplateInstance == timesheetTemplate
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/timesheetTemplate/list'


        populateValidParams(params)
        def timesheetTemplate = new TimesheetTemplate(params)

        assert timesheetTemplate.save() != null

        params.id = timesheetTemplate.id

        def model = controller.edit()

        assert model.timesheetTemplateInstance == timesheetTemplate
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/timesheetTemplate/list'

        response.reset()


        populateValidParams(params)
        def timesheetTemplate = new TimesheetTemplate(params)

        assert timesheetTemplate.save() != null

        // test invalid parameters in update
        params.id = timesheetTemplate.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/timesheetTemplate/edit"
        assert model.timesheetTemplateInstance != null

        timesheetTemplate.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/timesheetTemplate/show/$timesheetTemplate.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        timesheetTemplate.clearErrors()

        populateValidParams(params)
        params.id = timesheetTemplate.id
        params.version = -1
        controller.update()

        assert view == "/timesheetTemplate/edit"
        assert model.timesheetTemplateInstance != null
        assert model.timesheetTemplateInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/timesheetTemplate/list'

        response.reset()

        populateValidParams(params)
        def timesheetTemplate = new TimesheetTemplate(params)

        assert timesheetTemplate.save() != null
        assert TimesheetTemplate.count() == 1

        params.id = timesheetTemplate.id

        controller.delete()

        assert TimesheetTemplate.count() == 0
        assert TimesheetTemplate.get(timesheetTemplate.id) == null
        assert response.redirectedUrl == '/timesheetTemplate/list'
    }
}
