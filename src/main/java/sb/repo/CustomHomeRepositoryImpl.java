package sb.repo;

import org.springframework.stereotype.Repository;
import sb.entity.Home;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional()
public class CustomHomeRepositoryImpl implements CustomHomeRepository {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Home> getHomesByName(String name) {
        String q = "from Home where name like :name";
        Query query =  entityManager.createQuery(q);
        query.setParameter("name", "%"+name+"%");
        return query.getResultList();
    }
}
