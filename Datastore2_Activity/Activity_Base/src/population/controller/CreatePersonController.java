package population.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import population.common.GlobalConstants;
import population.dto.PersonDto;
import population.service.PersonService;

public class CreatePersonController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        PersonService personService = new PersonService();
        PersonDto personDto = new PersonDto();
        JSONObject json = null;

        try {
            Validators validator = new Validators(this.request);

            validator.add("fName", validator.required());
            validator.add("lName", validator.required());
            validator.add("address", validator.required());
            validator.add("age", validator.required());

            if (validator.validate()) {
                json = new JSONObject(new RequestMap(this.request));

                personDto.setFirstName(json.getString("fName"));
                personDto.setLastName(json.getString("lName"));
                personDto.setAddress(json.getString("address"));
                personDto.setAge(json.getLong("age"));

                personDto = personService.insertPerson(personDto);
            } else {
                json = new JSONObject();

                for (int i = 0; i < validator.getErrors().size(); i++) {
                    // add error message
                    personDto.addError(validator.getErrors().get(i));
                    System.out.println(validator.getErrors().get(i));
                }
            }
        } catch (Exception e) {
            // add error message
            personDto.addError(GlobalConstants.ERR_SERVER_CONTROLLER_PREFIX
                + e.getMessage());
            System.out.println(e.toString());
        }

        // add error messages to the json object.
        json.put("errorList", personDto.getErrorList());

        // set the type of response.
        response.setContentType(GlobalConstants.SYS_CONTENT_TYPE_JSON);
        // send the response back to JS.
        response.getWriter().write(json.toString());

        System.out.println("CreatePersonController.run " + "end");

        return null;
    }

}
