package part4;

public class Employee implements Cloneable{
    private int id;
    private String name;
    
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getId() {
        return this.id;
    }
    
    @Override
    protected Employee clone() throws CloneNotSupportedException{
        try {
            Employee cloned = (Employee) super.clone();
            return cloned;
        }
        catch(CloneNotSupportedException e){
            return null;
        }
    }
    
    @Override
    public String toString() {
        return "(" + name + ", "  + id +")";
    }
}
