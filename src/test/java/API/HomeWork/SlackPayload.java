package API.HomeWork;

public class SlackPayload {

    public static String getSlackPayload(String message){

        return "{\n" +
                "  \"channel\": \"C0164SXRETU\",\n" +
                "  \"text\": \""+message+"\"\n" +
                "}";

    }
}
