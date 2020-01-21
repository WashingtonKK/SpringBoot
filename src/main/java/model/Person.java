/*Here we are creating a model of the person want to have.
 * the attributes of the person being the name and an id
 * we have getters for the name and id
 * as well as a constructor to initiate the object (person)
 * 
 * 
 * 
 * 
 * 
 */

package model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	
	private final UUID id;
	private final String name;
	
	
	//The data person will be sent in form of a JSON
	//So we need to let Spring know how to convert the JSON sent into an object
	//To do that we use@JsonProperty("id") or whatever....
	public Person(@JsonProperty ("id")UUID id, 
				@JsonProperty ("name")String name) {
		this.id = id;
		this.name = name;
		}
	
	public UUID getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

}


