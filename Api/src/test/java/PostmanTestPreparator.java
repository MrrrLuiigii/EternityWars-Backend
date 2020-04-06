import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Models.Cards;
import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.Deck;
import com.eternitywars.api.Models.Entities.User;
import com.eternitywars.api.Models.Enums.AccountStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PostmanTestPreparator
{
    private static SessionFactory sessionFactory = ApiApplication.testSessionFactory;

    private Session session;
    private Transaction transaction;

    private void FillDatabaseWithTestEntities()
    {
        User user = new User(
                "MrrrLuiigii",
                "nicky.janse.nj@gmail.com",
                AccountStatus.Online, 200, 4
        );

        Card cardOne = new Card(
                "Dreadlord von Reemer",
                8, 5, 4, 2, true
        );

        Card cardTwo = new Card(
                "Friday",
                4, 4, 4, 0, false
        );

        Card cardThree = new Card(
                "Africa",
                12, 4, 8, 1, false
        );

        Card cardFour = new Card(
                "FedEx",
                1, 6, 3, 0, false
        );

        List<Card> cardCollection = new ArrayList<>();
        cardCollection.add(cardOne);
        cardCollection.add(cardTwo);
        cardCollection.add(cardThree);
        cardCollection.add(cardFour);
        user.setCardCollection(cardCollection);

        List<Card> cardsInFirstDeck = new ArrayList<>();
        cardsInFirstDeck.add(cardOne);
        cardsInFirstDeck.add(cardTwo);

        Deck firstDeck = new Deck("MyFirstDeck");
        firstDeck.setCards(cardsInFirstDeck);

        List<Card> cardsInSecondDeck = new ArrayList<>();
        cardsInSecondDeck.add(cardThree);
        cardsInSecondDeck.add(cardFour);

        Deck secondDeck = new Deck("MySecondDeck");
        secondDeck.setCards(cardsInSecondDeck);

        user.getDecks().add(firstDeck);
        user.getDecks().add(secondDeck);






    }
}
