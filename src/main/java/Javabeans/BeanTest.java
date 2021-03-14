package Javabeans;

import java.util.ArrayList;
import java.util.List;

public class BeanTest {
    public static void main(String[] args) {

        Album randomAlbum = new Album(1, "Random Guy", "Random Title", 1999, 12.3F, "Random Genre");

        Author randomAuthor = new Author();
        randomAuthor.setFirstName("Random");
        randomAuthor.setLastName("Guy");

        Quote randomQuote1 = new Quote(1, "Random quote 01", randomAuthor);
        Quote randomQuote2 = new Quote(2, "Random quote 02", new Author(1, "Randy", "randomson"));

        List<Quote> quotes = new ArrayList<>();
        quotes.add(randomQuote1);
        quotes.add(randomQuote2);

        for (Quote quote: quotes) {
            System.out.println(quote.getContent());
            System.out.println("~ " + quote.getAuthor().getLastName() + ", " + quote.getAuthor().getFirstName());
        }

    }

}
