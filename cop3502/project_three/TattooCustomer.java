public class TattooCustomer{

  private String name;
  private String tattoo;
  private int minutes;
  /**
   *  Constructor for the Tattoo Customer
   *  @params String name, String tattoo, int minutes
   */
  public TattooCustomer(String name, String tattoo, int minutes){
    this.name = name;
    this.tattoo = tattoo;
    this.minutes = minutes;
  }

  // Establish the getters for name, tattoo, and number of minutes

  /**
   * Returns the name of the TattooCustomer
   * @params None
   */
  public String getName(){
    return this.name;
  }

  /**
   * Returns the tattoo of the TattooCustomer
   * @params None
   */
  public String getTattoo(){
    return this.tattoo;
  }

  /**
   * Returns the minutes of the TattooCustomer
   * @params None
   */
  public int getMinutes(){
    return this.minutes;
  }

}
