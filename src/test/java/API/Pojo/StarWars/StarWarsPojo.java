package API.Pojo.StarWars;

import java.util.List;

public class StarWarsPojo {


    private int count;
    private String next;
    private Object previous;
    private List<ResultsPojo> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<ResultsPojo> getResults() {
        return results;
    }

    public void setResults(List<ResultsPojo> results) {
        this.results = results;
    }
}