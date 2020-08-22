package com.mainacad.service.railway;

import com.mainacad.service.railway.model.City;
import com.mainacad.service.railway.model.Person;
import com.mainacad.service.railway.model.Ticket;
import com.mainacad.service.railway.model.Wish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RailwayRunner {
    static Ticket ticket1 = new Ticket(City.Kyiv, City.Kharkiv);
    static Ticket ticket2 = new Ticket(City.Kharkiv, City.Kyiv);
    static Ticket ticket3 = new Ticket(City.Cherkasy, City.Kharkiv);
    static Ticket ticket4 = new Ticket(City.Cherkasy, City.Lviv);
    static Ticket ticket5 = new Ticket(City.Kyiv, City.Lviv);
    static Ticket ticket6 = new Ticket(City.Kharkiv, City.Ternopil);

    static Person person1 = new Person("Petro");
    static Person person2 = new Person("Ivan");
    static Person person3 = new Person("Maria");
    static Person person4 = new Person("Stepan");
    static Person person5 = new Person("Kateryna");

    static List<Wish> wishes = Arrays.asList(
            new Wish(1, person1, ticket1),
            new Wish(2, person2, ticket2),
            new Wish(3, person3, ticket3),
            new Wish(4, person4, ticket4),
            new Wish(5, person5, ticket5),
            new Wish(6, person1, ticket6),
            new Wish(7, person2, ticket1),
            new Wish(8, person1, ticket2),
            new Wish(9, person1, ticket3),
            new Wish(10, person2, ticket4),
            new Wish(11, person3, ticket5),
            new Wish(12, person4, ticket5));

    public static final String LINE_SEP = System.getProperty("line.separator");
    private static final String MAIN_MENU = LINE_SEP +
            "1 - Add wish to buy" + LINE_SEP +
            "2 – Add wish to sell" + LINE_SEP +
            "3 – Print" + LINE_SEP +
            "4 – Stop the program ";
    private static final String NUMBER_INPUT_TEXT = "Input number of wish";


    public static void main(String[] args) throws IOException {
        Action action = new Action();
        WishesToSell wishesToSell = new WishesToSell(action);
        WishesToBuy wishesToBuy = new WishesToBuy(action);
        Thread wishesToSellThread = new Thread(wishesToSell);
        Thread wishesToBuyThread = new Thread(wishesToBuy);
        wishesToSellThread.start();
        wishesToBuyThread.start();

        String line = "-";
        Pattern pattern = Pattern.compile("([1-4][1-4]*)");
        Matcher matcher = pattern.matcher(line);
        while (!matcher.matches()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(MAIN_MENU);
            line = bufferedReader.readLine();

            if (line.equals("1")) {
                Wish findedWish = inputWish();
                wishesToBuy.add(findedWish);
                System.out.println(findedWish + " is added to Wishes to BUY");
                action.setNewWishToBuyTicket(findedWish.getTicket());
            } else if (line.equals("2")) {
                Wish findedWish = inputWish();
                wishesToSell.add(findedWish);
                System.out.println(findedWish + "is added to Wishes to SELL");

            } else if (line.equals("3")) {
                wishesToSell.print();
                wishesToBuy.print();
            } else if (line.equals("4")) {
                System.exit(0);
            } else {
                System.out.println("Bad command ");
            }
        }
    }

    private static Wish inputWish() throws IOException {
        System.out.println(NUMBER_INPUT_TEXT);
        String line = "-";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line);
        while (!matcher.matches()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            line = bufferedReader.readLine();
            int index = Integer.valueOf(line);
            Optional<Wish> findedWish = wishes.stream().filter(x -> x.isIndex(index) == true).findFirst();

            if (findedWish.isPresent()) {
                return findedWish.get();
            } else
                System.out.println("Not found wish with such index");
        }
        return null;
    }

}


