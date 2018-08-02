package sb;

import org.springframework.context.annotation.ComponentScan;
import sb.entity.Home;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sb.repo.HomeRepository;

import java.util.List;

/**
 * Created by as46775 on 12/25/2017.
 */
@RestController
@EnableAutoConfiguration
@EnableJpaRepositories
@ComponentScan
public class HomeController {

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private HomeRepository homeRepository;

    @RequestMapping("/home")
    public String home(){
            return "Welcome to Home";
    }

    @RequestMapping(value = "/posthome")
    public void posthome(){
        Home home = new Home();
        home.setName("Home1");
        homeRepository.save(home);
    }

    @RequestMapping(value = "/gethome")
    public String gethome(){
        Home home = homeRepository.getOne(1L);
        return home.toString();
    }


    @RequestMapping(value = "/gethomebynane")
    public List<Home> gethomebyname(){
        List<Home> homes = homeRepository.getHomesByName("Home1");
        return homes;
    }



    public static void main(String[] args) throws Exception {
        logger.info("Inside {0} method {2}","main","executing");

        SpringApplication.run(HomeController.class, args);
    }

}
