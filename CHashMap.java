package seis;


import java.util.Map;
import java.util.HashMap;

public class CHashMap implements 1{

    private HashMap<Integer, Card> savedCards;

    public CHashMap(){
        savedCards = new HashMap<Integer, Card>();
    }

    @Override
    public void saveCard(Integer key, Card card){
        savedCards.put(key, card);
    }

    @Override
    public String showCards(){
        String informacion = "";

        for(Map.Entry<Integer, Card> carta: savedCards.entrySet()){
            Card cartaIndividual = carta.getValue();
            informacion += "-> " + cartaIndividual.getCardType() + ", [" + cartaIndividual.getNameCard() + "]\n";
        }

        return informacion;
    }

    @Override
    public String containsValue(String value) { // Obtener una carta en específico
        String obtenerCarta = "";

        for(Map.Entry<Integer, Card> carta: savedCards.entrySet()){
            Card cartaIndividual = carta.getValue();

            if(value.equals(cartaIndividual.getNameCard())){
                obtenerCarta = cartaIndividual.getNameCard();
                break;
            }
        }

        return obtenerCarta;
    }

    @Override
    public String getByCategory(String value) {
        return null;
    }
}
