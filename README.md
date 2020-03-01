# Functional Programming with Java ![Java CI](https://github.com/christopherfriedrich/javafunctional/workflows/Java%20CI/badge.svg?branch=master)

Comparison of imperative to functional / declarative programming in Java

## Why do i need functional programming in Java

* **Immutable State**: The state of an object doesn't change and hence need not be protected or synchronized. In functional programming, change in state occurs via series of transformations which keeps the object immutable and yet achieves change in state.
* **No side-effects**: The execution of a function has no side-effects,  a function code will always return same result for same argument when called multiple times. This makes it easy to understand and predict behaviour of program.

A nice side-effect of functional programming in Java is, that it shortens your source code e.g.:

```java
// Imperative Way
List<Person> females_imperative = new ArrayList<>();
for (Person person: people) {
    if(Gender.FEMALE.equals(person.getGender())){
        females_imperative.add(person);
    }
}
// Functional Way
Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.getGender());
List<Person> females_declarative = people.stream().filter(personPredicate).collect(Collectors.toList());
```
## Installation
First clone the repository and cd into it:
```bash
git clone https://github.com/christopherfriedrich/javafunctional.git
cd javafunctional/
```
Then install the Maven dependencies using
```bash
mvn install
```

## Running the tests

The tests mainly compare the imperative to the functional approach.
They can be run via
```bash
mvn test
```

