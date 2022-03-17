package seis;

public class Card {
	private String cardType;
    private String nameCard;

    public Card(String cardType, String nameCard){
        this.cardType = cardType;
        this.nameCard = nameCard;
    }

    public String getCardType() {
        return cardType;
    }

    public String getNameCard() {
        return nameCard;
    }
}
