import java.util.ArrayList;

public class Data {
    private String name;
    private String model;
    private String year;

    public static ArrayList<Data> cdata=new ArrayList<>();
    
    Data(String name,String model,String year){
        this.name=name;
        this.model=model;
        this.year=year;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
