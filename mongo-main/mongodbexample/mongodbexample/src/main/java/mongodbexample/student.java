package mongodbexample;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class student {

    @Id
    private int id;

    private String name;
  
    private String city;

    private String college;

    private String Branch;

    private float GPA;

 

    public student(int id, String name, String city, String college, String Branch, float GPA) {

        this.id = id;

        this.name = name;

        this.city = city;

        this.college = college;

        this.Branch = Branch;

        this.GPA = GPA;

    }

 

    public int getId() {

        return id;

    }

 

    public void setId(int id) {

        this.id = id;

    }

 

    public String getName() {

        return name;

    }

 

    public void setName(String name) {

        this.name = name;

    }

 

    public String getCity() {

        return city;

    }

 

    public void setCity(String city) {

        this.city = city;

    }

 

    public String getCollege() {

        return college;

    }

 

    public void setCollege(String college) {

        this.college = college;

    }

 

    public String getBranch() {

        return Branch;

    }

 

    public void setBranch(String Branch) {

        this.Branch = Branch;

    }

 

    public float getGPA() {

        return GPA;

    }

 

    public void setGPA(float GPA) {

        this.GPA = GPA;

    }

 

    public Object getAllStudents() {

        return null;

    }

 

}
