package th.mfu;

import java.util.List;

import org.apache.tomcat.jni.Address;
import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Concert;


public interface ConcertRepository extends CrudRepository<Concert, Long>{
      
}