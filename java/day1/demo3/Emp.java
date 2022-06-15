package day1.demo3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    String name;
    Integer age;
    Dog d;
    List<String> list;

    public Emp(String name){
        this.name = name;
    }

}
