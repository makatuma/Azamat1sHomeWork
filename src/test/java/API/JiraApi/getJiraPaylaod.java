package API.JiraApi;

public class getJiraPaylaod {


    public static String getJiraPayload(String summary, String description, String issueType){
        return "{\n" +
                "    \"fields\": {\n" +
                "        \"project\":{\n" +
                "            \"key\": \"TEC\"\n" +
                "        },\n" +
                "\n" +
                "        \"summary\":\""+summary+"\",\n" +
                "        \"description\" : \""+description+"\",\n" +
                "        \"issuetype\" : {\n" +
                "            \"name\": \""+issueType+"\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }
}
