package Model.Archive;

import Model.Calculator.Element;
import Model.Calculator.Result;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
public class Archive
{
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    public Archive()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
        entityManager = entityManagerFactory.createEntityManager();
    }

    /**
     * Creates a row with the results and its paramater
     * @param result contains a Results type containing all te components of the equastion
     */
    public void createRow(Result result)
    {
        Results results = new Results(result);
        entityManager.getTransaction().begin();
        entityManager.persist(results);
        entityManager.getTransaction().commit();
    }

    public List isPresent(Element base, Element power, Element modulo)
    {
    TypedQuery<Results> query = entityManager.createQuery("SELECT e FROM Results e WHERE e.Base='" + base.getDecimalForm() + "' and e.Modulo='" + modulo.getDecimalForm() + "' and e.Power='" + power.getDecimalForm() + "'", Results.class);
    List<Results> resultsList = query.getResultList();
    log.info(" the lentgh is " + resultsList.size());
    return resultsList;
    }

    public void Close()
    {
        entityManager.close();
        entityManagerFactory.close();
    }
}
