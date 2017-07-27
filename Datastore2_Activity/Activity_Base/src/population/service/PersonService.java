package population.service;

import population.common.GlobalConstants;
import population.dao.PersonDao;
import population.dto.PersonDto;
import population.model.PersonModel;

public class PersonService {
    PersonDao personDao = new PersonDao();

    public PersonDto insertPerson(PersonDto inputPerson) {
        PersonModel personModel = new PersonModel();

        personModel.setId(inputPerson.getId());
        personModel.setFirstName(inputPerson.getFirstName());
        personModel.setLastName(inputPerson.getLastName());
        personModel.setAddress(inputPerson.getAddress());
        personModel.setAge(inputPerson.getAge());

        try {
            personDao.insertPerson(personModel);
        } catch (Exception e) {
            inputPerson.addError(GlobalConstants.ERR_DB_EXCEPTION);
        }

        return inputPerson;
    }

}
