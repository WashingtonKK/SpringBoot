/*Here we configure our java code to use springboot
 * We also handle the post get and put or delete requests
 * We also are making it a REST controller
 */

package api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Person;
import service.PersonService;

//We use @RequestMapping to indicate the path of our JSON


//We use @RestController to initiate the class as a rest controller

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

	private final PersonService personService;
	
	//Dependency injection
	@Autowired 
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	//We want this method to serve as the post request
	//to do that we use @PostMapping
	//Here is where postman comes in
	//It is a client
	//We need to tell our class that the values of name are being received from the JSON sent
	//To do that we use @RequestBody
	@PostMapping
	public void addPerson (@RequestBody Person person) {
		personService.addPerson(person);
	}
	
	//Method to be run when we send a get request
	@GetMapping
	public List<Person> getAllPeople () {
		return personService.getAllPeople();
	}
	
	@GetMapping(path = "{id}")
	public Person getPersonById(@PathVariable("id") UUID id) {
		return personService.getPersonById(id)
				.orElse(null);
	}
	
	@DeleteMapping(path = {"id"})
	public void deletePersonById(@PathVariable("id") UUID id) {
		personService.deletePerson(id);
	}
	
	
	@PutMapping(path = "{id}")
	public void updateperson(@PathVariable("id")UUID id , @RequestBody Person personToUpdate) {
		personService.updatePerson(id, personToUpdate);
	}
}
