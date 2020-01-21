/*Here we are inserting people into the database we create
 * any database we choose, 
 * Here we use an arrayList to store the objects
 * so we have 2 methods, one lets us add a person and gives a random id 
 * the other creates a person with the id you give
 */

package dao;

import java.util.UUID;

import model.Person;

public interface PersonDao {

	int insertPerson(UUID id, Person person);
	
	default int insertPerson (Person person ) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}

}
