package hellojpa;

import javax.persistence.*;
import java.util.Date;

// jpa 에서 관리해야 할 클래스(테이블과 매핑할 클래스)임을 명시
// 기본 생성자 필수(파라미터가 없는 public 또는 protected 생성자)
// final 클래스, enum, interface, inner 클래스 사용 X
@Entity
// 인자로 주어진 이름과 같은 table 에서 작업을 수행
//@Table(name = "name")
public class Member {

    // primary key 가 무엇인지 알려줌
    @Id
    private Long id;

    // name 속성 : class 에서 쓴 변수와 DB의 컬럼이 매칭이 안될 경우 인자로 주어진 변수를 컬럼으로 사용해서 매칭함
    // unique 속성 : 값이 유일해야 하는지 (true or false) : 쓰지 않는 걸 추천
    // length 속성 : 길이 제한 (String 타입에만 사용)
    // updatable 속성 : 등록, 변경 가능 여부
    // nullable 속성 : null 값의 허용 여부 설정
    // columnDefinition 속성 : 데이터베이스 컬럼 정보를 직접 줄 수 있다.
    @Column(name ="name")
    private String username;

    private Integer age;

    // enum 타입을 매핑할 때 사용
    // EnumType.ORDINAL : enum 순서를 데이터베이스에 저장
    // EnumType.STRING : enum 이름을 데이터베이스에 저장
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // Temporal은 날짜를 매핑할 때 쓰인다.
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // 길이 제한이 없는 콘텐츠를 넣고 싶을 경우
    @Lob
    private String description;

    // 컬럼에 매핑하지 않고 메모리에서만 사용하겠다는 뜻
    @Transient
    private int temp;

    public Member(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
