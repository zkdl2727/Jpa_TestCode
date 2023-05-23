package hellojpa;


import net.bytebuddy.agent.builder.AgentBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Parent parent = new Parent();

            

            Child c1 = new Child();
            Child c2 = new Child();

          parent.addChild(c1);
          parent.addChild(c2);

          em.persist(parent);

          em.flush();
          em.clear();

          Parent findParent = em.find(Parent.class,parent.getId());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }

}
