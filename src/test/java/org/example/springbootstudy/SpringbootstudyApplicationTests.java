package org.example.springbootstudy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.springbootstudy.DAO.StudentRepository;
import org.example.springbootstudy.entity.Customer;
import org.example.springbootstudy.entity.Student;
import org.example.springbootstudy.entity.User;
import org.example.springbootstudy.mapper.CustomerMapper;
import org.example.springbootstudy.mapper.User1Mapper;
import org.example.springbootstudy.pojo.Subject;
import org.example.springbootstudy.service.UserService;
import org.example.springbootstudy.utils.AnyFunction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@Slf4j
class SpringbootstudyApplicationTests {

    @Resource
    JavaMailSender mailSender;

    @Resource
    User1Mapper mapper;

    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
//        //简单的邮件封装
//        SimpleMailMessage mail = new SimpleMailMessage();
//        //设置邮件标题
//        mail.setSubject("【电子科技大学教务处】关于近期学校对您的处分决定");
//        //设置邮件内容
//        mail.setText("XXX同学你好，根据您的XXXXXX");
//        //发送对象, 可以多个
//        mail.setTo("978090944@qq.com", "f978090944@gmail.com");
//        //设置发送者
//        mail.setFrom("fzm978090944@163.com");
//        //发送
//        mailSender.send(mail);

//        QueryWrapper<User> wrapper = Wrappers
//                .<User>query()
//                .gt("id", 1)
//                .orderByDesc("id");

//        System.out.println(mapper.selectList(wrapper));
    }

    @Resource
    CustomerMapper customerMapper;

    @Rollback(value = false)
    @Test
    void testInsert() {
        customerMapper.deleteById(999);
        customerMapper.insert(new Customer(999, 1, "First", "Last", "xxx@163.com", 1, true));
        Customer customer = customerMapper.selectById(999);
        log.info("{}", customer);
        List<Customer> customers = customerMapper.selectList(new QueryWrapper<>());
        log.info("{}", customers);
    }


    @Resource
    StudentRepository studentRepository;

    //@BeforeEach
    public void init() {
//        Student engStudent = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
//        engStudent.getBooks().add(new Book("Java", "Java is a programming language"));
//        engStudent.getBooks().add(new Book("Python", "Java is a programming language"));
//        engStudent.getBooks().add(new Book("C++", "Java is a programming language"));
//
//        Student medStudent = new Student("Med2015001", "Gareth Houston", Student.Gender.MALE, 2);
//
//        studentRepository.save(engStudent);
//        studentRepository.save(medStudent);
    }

    //@AfterEach
    public void destroy() {
        studentRepository.deleteById("Eng2015001");
        studentRepository.deleteById("Med2015001");
    }

    @Test
    public void update() {
        Student retrieveStudent = studentRepository.findById("Eng2015001").get();
        retrieveStudent.setGrade(2);
        studentRepository.save(retrieveStudent);
        System.out.println(studentRepository.findById("Eng2015001").get());
    }

    @Test
    public void query() {
        Iterable<Student> students = studentRepository.findAll();
        students.forEach(System.out::println);
    }

    @Test
    public void query2() {
//        SubjectImpl subject = new SubjectImpl(); //被代理的类
//        Enhancer enhancer = new Enhancer(); //增强器，依赖增强器生成动态代理对象
//        enhancer.setSuperclass(SubjectImpl.class);  //需要代理的类型，不需要接口或者抽象类，SuperClass作为代理类的父类存在
//        enhancer.setCallback(new TestProxy(subject));   //代理逻辑
//        SubjectImpl proxy = (SubjectImpl) enhancer.create();//创建代理类
//        proxy.test();
    }

    @Test
    public void test3() {
        Subject subject = new Subject();
        subject.addObserver(() -> System.out.println("我是观察者1号"));
        subject.addObserver(() -> System.out.println("我是观察者2号"));
        subject.modify();
    }

    @Test
    public void test4() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        Collections.sort(list, (o1, o2) -> o1 - o2);
        System.out.println(list);
    }

    @Autowired
    AnyFunction anyFunction;

    @Test
    public void test5() {
        System.out.println(anyFunction.div(1, 1));
    }

    @Test
    public void test6(){
        User user = new User();
        user.setName("德川家康");
        userService.saveUser(user);
    }

    @Test
    public void test8(){
        User user = new User();
        user.setName("德川家康");
        System.out.println(userService.findById(-265113598));
    }

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void test7(){
        redisTemplate.opsForValue().set("111","anson");
        System.out.println(redisTemplate.opsForValue().get("111"));
    }

}
