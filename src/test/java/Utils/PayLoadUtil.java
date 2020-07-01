package Utils;

public class PayLoadUtil {
    public static String getPetPayload(int id, String name, String status){
        return "{\n" +
                "  \"id\":"+id+",\n" +
                "  \"category\": {\n" +
                "    \"id\":0 ,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";

    }
}
