package com.mainacad.service.railway;

public class RailwayRunner {
    public static void main(String[] args) {
        Ticket ticket1=new Ticket(City.Kyiv, City.Kharkiv);
        Ticket ticket2=new Ticket(City.Kharkiv, City.Kyiv);
        Ticket ticket3=new Ticket(City.Cherkasy, City.Kharkiv);
        Ticket ticket4=new Ticket(City.Cherkasy, City.Lviv);
        Ticket ticket5=new Ticket(City.Kyiv, City.Lviv);
        Ticket ticket6=new Ticket(City.Kharkiv, City.Ternopil);

        Person person1 = new Person("Petro");
        Person person2 = new Person("Ivan");
        Person person3 = new Person("Maria");
        Person person4 = new Person("Stepan");
        Person person5 = new Person("Kateryna");



    }
}
