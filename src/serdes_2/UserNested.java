package serdes_2;

public class UserNested{
    private int age;
    private String name;
    private String email;

    //new
    private UserAddress userAddress;

    public UserNested(int age, String name, String email, UserAddress userAddress){
        this.age = age;
        this.name = name;
        this.email = email;
        this.userAddress = userAddress;
    }
}
