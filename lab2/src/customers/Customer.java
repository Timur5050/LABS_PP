package customers;

public class Customer {
    private static int idIncrement = 0;

    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String cardNumber;
    private int balance;

    public Customer(
            String _lastName,
            String _firstName,
            String _middleName,
            String _address,
            String _cardNumber,
            int _balance
    ) {
        id = idIncrement++;
        lastName = _lastName;
        firstName = _firstName;
        middleName = _middleName;
        address = _address;
        setCardNumber(_cardNumber);
        balance = _balance;
    }
    public void setLastName(String _lastName)
    {
        lastName = _lastName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setFirstName(String _firstName)
    {
        firstName = _firstName;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setMiddleName(String _middleName)
    {
        middleName = _middleName;
    }
    public String getMiddleName()
    {
        return middleName;
    }
    public void setAddress(String _address)
    {
        address = _address;
    }
    public String getAddress()
    {
        return address;
    }
    public void setCardNumber(String _cardNumber)
    {
        if(_cardNumber.length() != 16)
        {
            throw new IllegalArgumentException("card number length must be - 16");
        }
        cardNumber = _cardNumber;
    }
    public String getCardNumber()
    {
        return cardNumber;
    }
    public void setBalance(int _balance)
    {
        balance = _balance;
    }
    public int getBalance()
    {
        return balance;
    }

    @Override
    public String toString()
    {
        return "user with id " + id + ": " + this.firstName + " " + this.lastName + " " + this.middleName +
                ", address: " + this.address + ", card number: " +
                this.cardNumber + ", balance: " + this.balance;
    }
}