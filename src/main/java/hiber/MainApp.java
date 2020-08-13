package hiber;

import hiber.config.AppConfig;
import hiber.model.Auto;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Дмитрий", "Пирог", "pirog@mail.ru", new Auto("Audi",7)));
      userService.add(new User("Roy", "Johnes", "johnes@mail.ru"));
      userService.add(new User("Mike", "Tyson", "tyson@mail.ru"));
      userService.add(new User("Saul", "Alvares", "alvares@mail.ru"));
      userService.add(new User("Vasya","Lomachenko","loma@mail.ru", new Auto("Gelendewagen",500)));

      User gena = new User("Gennady", "Golovkin", "golovkin@mail.ru");

      gena.setAuto(new Auto("Tesla",15));

      userService.add(gena);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Auto = "+user.getAuto());
         System.out.println();
      }
      System.out.println(userService.getUserByIdAuto(500));

      context.close();
   }
}
