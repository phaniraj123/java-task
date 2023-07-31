package mongodbexample;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StuRep extends MongoRepository<student, Integer> {
    void deleteById(Integer id);

}
    

