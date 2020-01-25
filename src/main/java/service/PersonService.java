package service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import dao.PersonDao;
import model.Person;

//For a service we use @Service, or also @Component
//contains all the logic that our application will need and use
@Service
public class PersonService {
	
	private final PersonDao personDao;
	
	//We are injecting into the constructor thus we use @Autowired
	@Autowired
	private PersonService (@Qualifier("fakeDao")PersonDao personDao)  {
		this.personDao = personDao;
	}
	//We use @Qualifier since we want a way to distinguish which out of 
	//several instances that may be created
	//We would name it mongo or postgress if we were using either of the two
	
	public int addPerson (Person person) {
		return personDao.insertPerson( person);
	}
	
	public List<Person> getAllPeople() {
		return personDao.selectAllPeople();
	}

	public Optional<Person> getPersonById( UUID id) {
		return personDao.selectPersonById(id);
	}
	
	public int deletePerson(UUID id) {
		return personDao.deletePersonById(id);
	}
	
	public int updatePerson(UUID id, Person newPerson) {
		return personDao.updatePersonById(id, newPerson);
	}
}
