package API.HomeWork.PetSwagger;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class PetPayLoad {



    public static String getPetPayload(Long id){
        Faker faker = new Faker();
        String name = faker.cat().name();
        System.out.println(name);


     return "{\n" +
             "  \"id\":"+id+",\n" +
             "  \"category\": {\n" +
             "    \"id\":0 ,\n" +
             "    \"name\": \"string\"\n" +
             "  },\n" +
             "  \"name\": \"" + name+ "\",\n" +
             "  \"photoUrls\": [\n" +
             "    \"string\"\n" +
             "  ],\n" +
             "  \"tags\": [\n" +
             "    {\n" +
             "      \"id\": 0,\n" +
             "      \"name\": \"string\"\n" +
             "    }\n" +
             "  ],\n" +
             "  \"status\": \"Sold\"\n" +
             "}";
    }

}
