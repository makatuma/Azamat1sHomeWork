package API.HomeWork.GameOFThrones;

import API.HomeWork.GameOFThrones.Data;

import java.util.List;

public class GOTPojo {

    private String message;
    private List<Data> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
