import serdes_1.User;

import com.google.gson.Gson;
import serdes_2.UserAddress;
import serdes_2.UserNested;

public class Main {

    public static void main(String[] args) {

        serializeUser();
        deserializeUser();
        serializationUserNested();

        }

        private static void serializeUser() {
            User user = new User(25, "Smith", "Smith@gmail.com");

            Gson gson = new Gson();
            String json = gson.toJson(user);
            System.out.println(json);
        }

        private static void deserializeUser() {
            String userJson = "{'age': 30, 'name': 'Valera', 'email': 'Valera@gmail.com'}";

            Gson gson = new Gson();
            User user_des = gson.fromJson(userJson, User.class);
            System.out.println(user_des);
        }

        private static void serializationUserNested(){
            UserAddress userAddress = new UserAddress("Pobedy", "10","Luninets", "Belarus");
            UserNested userNested = new UserNested(25, "Jane", "Jane@gmail.com", userAddress);

            Gson gson = new Gson();
            String json_2 = gson.toJson(userNested);
            System.out.println(json_2);
        }
}

