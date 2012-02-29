package cpt



import org.junit.*

import cpt.Tool;
import cpt.ToolController;
import grails.test.mixin.*

@TestFor(ToolController)
@Mock(Tool)
class ToolControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/tool/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.toolInstanceList.size() == 0
        assert model.toolInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.toolInstance != null
    }

    void testSave() {
        controller.save()

        assert model.toolInstance != null
        assert view == '/tool/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/tool/show/1'
        assert controller.flash.message != null
        assert Tool.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/tool/list'


        populateValidParams(params)
        def tool = new Tool(params)

        assert tool.save() != null

        params.id = tool.id

        def model = controller.show()

        assert model.toolInstance == tool
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/tool/list'


        populateValidParams(params)
        def tool = new Tool(params)

        assert tool.save() != null

        params.id = tool.id

        def model = controller.edit()

        assert model.toolInstance == tool
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/tool/list'

        response.reset()


        populateValidParams(params)
        def tool = new Tool(params)

        assert tool.save() != null

        // test invalid parameters in update
        params.id = tool.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/tool/edit"
        assert model.toolInstance != null

        tool.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/tool/show/$tool.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        tool.clearErrors()

        populateValidParams(params)
        params.id = tool.id
        params.version = -1
        controller.update()

        assert view == "/tool/edit"
        assert model.toolInstance != null
        assert model.toolInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/tool/list'

        response.reset()

        populateValidParams(params)
        def tool = new Tool(params)

        assert tool.save() != null
        assert Tool.count() == 1

        params.id = tool.id

        controller.delete()

        assert Tool.count() == 0
        assert Tool.get(tool.id) == null
        assert response.redirectedUrl == '/tool/list'
    }
}
