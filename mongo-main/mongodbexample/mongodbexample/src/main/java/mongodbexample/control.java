package mongodbexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class control {
    @Autowired
   private StuRep stuRepo;
    @PostMapping("/")
    public ResponseEntity<student> addstudent(@RequestBody student stu) {

        student save = this.stuRepo.save(stu);

        return ResponseEntity.ok(save);
    }
  @GetMapping("/")

    public ResponseEntity<List<student>> getstudents() {

 

        return ResponseEntity.ok(stuRepo.findAll());

 

    }
    @GetMapping("/{id}")

    public student getBookById(@PathVariable Integer id) {

        return stuRepo.findById(id).orElse(null);

    }
  @PutMapping("/")

    public ResponseEntity<student> updateStudent(@RequestBody student stu) {

        return ResponseEntity.ok(this.stuRepo.save(stu));

    }

 

    @DeleteMapping("/{id}")

    public void deleteStudent(@PathVariable int id) {

        stuRepo.deleteById(id);

 

    }
    
}
