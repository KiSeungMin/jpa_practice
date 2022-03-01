package hellojpa;

import javax.persistence.*;

// jpa 에서 관리해야 할 클래스임을 명시
@Entity
// 인자로 주어진 이름과 같은 table에서 작업을 수행
//@Table(name = "name")
public class Member {

    // primary key 가 무엇인지 알려줌
    @Id
    private Long id;

    // class에서 쓴 변수와 DB의 컬럼이 매칭이 안될 경우 인자로 주어진 변수를 컬럼으로 사용해서 매칭함
    //@Column(name ="name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
