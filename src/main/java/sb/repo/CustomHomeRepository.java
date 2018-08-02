package sb.repo;

import sb.entity.Home;

import java.util.List;

public interface CustomHomeRepository {

    List<Home> getHomesByName(String name);
}
