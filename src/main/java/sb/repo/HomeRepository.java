package sb.repo;


import sb.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface HomeRepository extends JpaRepository<Home,Long>, CustomHomeRepository {


}
