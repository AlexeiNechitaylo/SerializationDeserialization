import serdes.User;

import com.google.gson.Gson;
import serdes_arrays_lists.Founder;
import serdes_arrays_lists.GeneralInfo;
import serdes_arrays_lists.Restaurant;
import serdes_nested.UserAddress;
import serdes_nested.UserNested;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        serializeUser();
        deserializeUser();
        //Nested
        serializationUserNested();
        deserializeUserNested();
        //Arrays and Lists
        serializeRestaurant();
        deserializeFS();
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

        private static void serializeRestaurant(){
            List<Restaurant.RestaurantMenuItem> menuItems = new ArrayList<>();
            menuItems.add(new Restaurant.RestaurantMenuItem("Steak", 20f));
            menuItems.add(new Restaurant.RestaurantMenuItem("Spaghetti", 5f));
            menuItems.add(new Restaurant.RestaurantMenuItem("Pizza", 15f));

            Restaurant restaurant = new Restaurant("DANTE", menuItems);

            Gson gson = new Gson();
            String json_3 = gson.toJson(restaurant);
            System.out.println(json_3);
        }

        private static void deserializeFS(){
            String FSjson = "[{\"name\": \"Christian\",\"flowerCount\": 1},{\"name\": \"Marcus\",\"flowerCount\": 3},{\"name\": \"Norman\",\"flowerCount\": 2}]";

            Gson gson = new Gson();
            //Founder[] founders_array = gson.fromJson(FSjson, Founder[].class);
            //List<Founder> founders_list = new Gson().fromJson(FSjson, List<Founder>);

            String generalinfo = "{\n" +
                    "  \"name\": \"Roga i kopita\",\n" +
                    "  \"website\": \"\",\n" +
                    "  \"founders\": [\n" +
                    "    {\n" +
                    "      \"name\": \"Christian\",\n" +
                    "      \"flowerCount\": \"1\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\": \"Marcus\",\n" +
                    "      \"flowerCount\": \"3\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\": \"Norman\",\n" +
                    "      \"flowerCount\": \"2\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";

            GeneralInfo g_info = gson.fromJson(generalinfo, GeneralInfo.class);
            System.out.println(g_info);
        }
}

