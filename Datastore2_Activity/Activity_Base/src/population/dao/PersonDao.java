package population.dao;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;

import population.model.PersonModel;

public class PersonDao {
    
    /**
     * This property is used to call datastore api native functions.
     */
    DatastoreService dataService = DatastoreServiceFactory.getDatastoreService();

    /**
     * This function is used to convert a 'Model' obejct created using slim3 framework
     * (which will be discussed in next lesson) into an 'Entity' object (native class in Datastore API).
     * 
     * @param inputPerson - the model to be converted
     * @return the entity from PersonModel.
     */
    private Entity modelToEntity(PersonModel inputPerson) {
        Entity person = new Entity(inputPerson.getKey());
        person.setProperty("id", inputPerson.getId());
        person.setProperty("firstName", inputPerson.getFirstName());
        person.setProperty("lastName", inputPerson.getLastName());
        person.setProperty("address", inputPerson.getAddress());
        person.setProperty("age", inputPerson.getAge());
        /*TODO: Set the firstName, lastName, address, age
         * properties of the 'person' entity. Refer to the above
         * implementation.*/
        return person;
    }

	/**
     * This function is used to add the entity into the datastore.
     * 
     * @param inputPerson - model to be added into the datastore.
     */
    public void insertPerson(PersonModel inputPerson) {
        // create the key and id
        Key parentKey = KeyFactory.createKey("Person", inputPerson.getFirstName());
        Key key = Datastore.allocateId(parentKey, "Person");
        inputPerson.setKey(key);
        inputPerson.setId(key.getId());
        // create the entity
        /*TODO: Convert the 'inputPerson' model to Entity object.
         * Note: use the modelToEntity(inputPerson) function.*/
        Entity personEntity = modelToEntity(inputPerson);
        /*TODO: Create a transaction using the beginTransaction() function
         * of the 'dataService' object.*/
        Transaction trans = dataService.beginTransaction();
        /*TODO: Insert the entity to the datastore.*/
        dataService.put(trans,personEntity);
        /*TODO: Commit the transaction.*/
        trans.commit();
    }

}
