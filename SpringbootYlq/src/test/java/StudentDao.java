import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.App;
import com.dao.StudentMapper;
import com.entity.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class StudentDao {

    @Resource
    private StudentMapper StudentMapper;

    @Test
    public void  findAllUser() {

         List<Student> list = StudentMapper.findAll();
         for(Student s :list) {
             System.out.println(s);
         }
    }
}


