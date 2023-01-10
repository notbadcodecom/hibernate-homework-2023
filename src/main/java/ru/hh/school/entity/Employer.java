package ru.hh.school.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//TODO: оформите entity
@Entity
@Table(name = "employer", schema = "public")
public class Employer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employer_id", nullable = false, updatable = false)
  private Integer id;

  @Column(name = "company_name", nullable = false)
  private String companyName;

  // не используйте java.util.Date
  // https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#basic-datetime-java8
  @CreationTimestamp
  @Column(name = "creation_time", nullable = false, updatable = false)
  private LocalDateTime creationTime;

  @OneToMany(mappedBy="employer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Vacancy> vacancies = new ArrayList<>();

  @Column(name = "block_time")
  private LocalDateTime blockTime;

  public List<Vacancy> getVacancies() {
    return vacancies;
  }

  public Integer getId() {
    return id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public LocalDateTime getBlockTime() {
    return blockTime;
  }

  public void setBlockTime(LocalDateTime blockTime) {
    this.blockTime = blockTime;
  }

  // статьи на тему реализации equals() и hashCode():
  //
  // https://vladmihalcea.com/hibernate-facts-equals-and-hashcode/
  // https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    Employer otherEmployer = (Employer) object;
    return id.equals(otherEmployer.getId())
            && companyName.equals(otherEmployer.getCompanyName());
  }

  @Override
  public int hashCode() {
    int hash = id * id;
    hash = 31 * hash + (companyName == null ? 0 : companyName.hashCode());
    return 31 * hash;
  }

}
