package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        // persistenceUnitName은 persistence.xml의 unit name을 말한다.
        // EntityManagerFactory를 만드는 순간 데이터베이스와 연결이 된다.
        // 딱 하나만 만들어야 함
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // EntityManager 생성
        // 쿼리를 생성, 반영하는 등의 작업을 할 때마다 만들어주어야 함
        // EntityManager는 자바의 Collection과 같다고 생각하면 편하다.
        // EntityManager는 쓰레드간에 공유X
        EntityManager em = emf.createEntityManager();

        // transaction은 모든 수행의 기본 단위이다.
        // JPA의 모든 데이터 변경은 transaction 안에서 실행되어야 한다.
        EntityTransaction tx = em.getTransaction();

        // transaction 시작
        // 엔티 메니저는 데이터 변경 시 트랜잭션을 시작해야 한다.
        tx.begin();

        try{
            /*
            멤버 생성
            Member member = new Member();

            member.setId(2L);
            member.setName("HelloB");
            */


            // 멤버 찾기
            // 첫 번째 인자 : 찾을 클래스, 두 번째 인자 : primary key
            // Member findMember = em.find(Member.class, 1L);
            // System.out.println(findMember.getId());

            // 멤버 수정
            // em.persist를 하지 않아도 알아서 저장된다 (commit 시점에서 바뀌게 됨)
            // findMember.setName("HelloJPA");

            // find를 통해 찾은 멤버 삭제
            // em.remove(findMember);

            // 객체를 저장함
            // 영속성 컨텍스트 - 엔티티를 영구 저장함
            //em.persist(member);

            // jpa에서도 쿼리를 사용하여 검색을 하는 것이 가능하다.(JPQL)
            // JPQL은 엔티티 객체를 대상으로 쿼리를 한다.
            // SQL은 데이터베이스 테이블을 대상으로 쿼리를 한다.
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            // transaction commit
            // 영속성 컨텍스트에 있는 쿼리가 반영된다.
            tx.commit();

        } catch(Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        // 애플리케이션이 끝날 경우
        emf.close();
    }
}
