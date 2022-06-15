package day1.demo4;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Data
@Service("service")
public class UserServiceImpl {
    //    1.根据类型注入,如果要根据bean name注入，要用@Qualifier
    @Autowired
//    @Qualifier("p1")
//    //    2.resource
//    @Resource
    Person p;
    @Value("zhangsan")
    String name;
}
