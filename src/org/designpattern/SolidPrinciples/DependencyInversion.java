package org.designpattern.SolidPrinciples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mritunjay Yadav
 * 
 * A. DependencyInversion says A high-level module should not depend upon a low level module both should depend on abstraction
 * B. Abstractions should not depend on details .
 * Details should depend on abstraction .
 *
 */

enum Relationship{
	PARENT ,
	CHILD ,
	SIBLINGS
}

class Triplet<T,K,M>{
	
	private T first ;
	private K second ;
	private M third ;
	
	public Triplet(T first, K second, M third) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
	}
	public T getFirst() {
		return first;
	}
	public void setFirst(T first) {
		this.first = first;
	}
	public K getSecond() {
		return second;
	}
	public void setSecond(K second) {
		this.second = second;
	}
	public M getThird() {
		return third;
	}
	public void setThird(M third) {
		this.third = third;
	}
	@Override
	public String toString() {
		return "Triplet [first=" + first.toString() + ", second=" + second + ", third=" + third.toString() + "]";
	}
}

class Person {
	
	private String name ;

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
}

interface RelationshipBrowser{
	
	public List<Person> findWhenParent();
}

class Relationships implements RelationshipBrowser{ // low-level class because it only has the logic to save and update relationship list 
	
	private List<Triplet<Person , Relationship , Person>> relations = new ArrayList<>();

	public void addParent(Person parent , Person child) { 
		relations.add(new Triplet<Person, Relationship, Person>(parent , Relationship.PARENT , child));
		relations.add(new Triplet<Person , Relationship , Person>(child , Relationship.CHILD , parent));
	}

	public List<Triplet<Person, Relationship, Person>> getRelations() { // and we are exposing internal implementation of data store as public getter 
		return relations;
	}

	@Override
	public List<Person> findWhenParent() {
		return relations.stream()
		.filter(relation -> relation.getFirst().getName().equals("Vijendra") && relation.getSecond() == Relationship.PARENT)
		.map(rel -> rel.getFirst()).collect(Collectors.toList());
		
	}
	
}



// here Research is a high-level component because it has business logic and is directly using a low-level 
// class Reslationships instance which is making it tightly coupled and violating Dependency inversion principle
// So according to dependencyInversion we should introduce an abstraction layer bw high-level and low-level classes

// now after introducting RelationshipBrowser interface we have introduced abstraction level and decouple it from direct
// dependency on low-level class
class Research{
	
	public Research(RelationshipBrowser relationsobj) { // here tightly coupled with relationships class 
		relationsobj.findWhenParent().forEach(person -> System.out.println(person.getName()));
	}
}

public class DependencyInversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Relationships relationships = new Relationships();
		relationships.addParent(new Person("Vijendra"), new Person("Mritunjay"));
		relationships.addParent(new Person("Vijendra"), new Person("Tanuj"));
		
		new Research(relationships);
	}

}
