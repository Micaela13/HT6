package seis;

public interface IMap {

	  public void saveCard(Integer key, Card card);

	    public String showCards();

	    public String containsValue(String value);

	    public String getByCategory(String value);

	    public String toString();

	}
