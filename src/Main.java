import serdes.User;

import com.google.gson.Gson;
import serdes_nested.UserAddress;
import serdes_nested.UserNested;

public class Main {

    public static void main(String[] args) {

        serializeUser();
        deserializeUser();
        serializationUserNested();
        deserializeUserNested();

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
            UserAddress userAddress = new UserAddress("Pobedy", "3","Luninets", "Belarus");
            UserNested userNested = new UserNested(25, "Jane", "Jane@gmail.com", userAddress);

            Gson gson = new Gson();
            String json_2 = gson.toJson(userNested);
            System.out.println(json_2);
        }

        private static void deserializeUserNested(){
            String userNestedJson = "{\"age\":25,\"name\":\"Jane\",\"email\":\"Jane@gmail.com\",\"userAddress\":{\"street\":\"Pobedy\",\"houseNumber\":\"10\",\"city\":\"Luninets\",\"country\":\"Belarus\"}}";

            Gson gson = new Gson();
            UserNested userNested_des = gson.fromJson(userNestedJson, UserNested.class);
            System.out.println(userNested_des);
        }
}

