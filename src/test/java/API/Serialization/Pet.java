package API.Serialization;

public class Pet {

    private String name;
    private  int age;
    private String status;
    private int id;
    private String photoUrl;



    public Pet(String name, String status, int age){

    }

    public void setName(String name){
        this.name= name;
    }

    public String getName(){
        return name;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }





}
