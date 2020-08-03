package com.surya.springboot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surya.springboot.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
/*	
@Table(name = "users")
@Entity
class User {
    @Id
    @GeneratedValue
    private Integer id;
     
    private String name;
    private Integer age;
    private ZonedDateTime birthDate;
    private Boolean active;
 
    // standard getters and setters
}
	
	
	//Equality Condition Keywords
	
	List<User> findByName(String name);
	
	List<User> findByNameIsNull();
	
	List<User> findByNameIsNotNull();
	
	List<User> findTop3ByAge();
	
	List<User> findByActiveTrue();

	List<User> findByActiveFalse();

	
	//Similarity Condition Keywords
	
	List<User> findByNameStartingWith(String prefix);
	
	List<User> findByNameContaining(String infix);
	
	List<User> findByNameLike(String likePattern); //likePattern = "a%b%c"
	
	
	//Comparison Condition Keywords
	
	List<User> findByAgeLessThan(Integer age);
	
	List<User> findByAgeLessThanEqual(Integer age);
	
	List<User> findByAgeBetween(Integer startAge, Integer endAge);
	
	List<User> findByAgeIn(Collection<Integer> ages);
	
	List<User> findByBirthDateAfter(ZonedDateTime birthDate);
	
	List<User> findByBirthDateBefore(ZonedDateTime birthDate);
	
	
	//Multiple Condition Expressions
	
	List<User> findByNameOrBirthDate(String name, ZonedDateTime birthDate);
	
	List<User> findByNameOrBirthDateAndActive(String name, ZonedDateTime birthDate, Boolean active);
	
	//Sorting the Results
	
	List<User> findByNameOrderByName(String name);
	
	List<User> findByNameOrderByNameDesc(String name);

	
	*/

}
