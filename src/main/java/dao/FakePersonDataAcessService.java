/*
 * Implements the interface PersonDao thus implements all the methods 
 * The two methods are insertPerson and addPerson
 * 
 */

package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import model.Person;


//This class needs to be instantiated as a bean so that it can be injected in other classes
//We can also use @Component
@Repository("fakeDao") //Allows us to have multiple inmplementations
public class FakePersonDataAcessService implements PersonDao {
	
	//The list to store the object Person
	private static List<Person> DB = new ArrayList<>();
	
	
	@Override
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		DB.add(new Person(id, person.getName()));
		return 1;
	}

}
