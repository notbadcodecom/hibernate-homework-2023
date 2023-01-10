package ru.hh.school.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

//TODO: оформите entity
@Entity
@Table(name = "vacancy", schema = "public")
public class Vacancy {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "vacancy_id", nullable = false, updatable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="employer_id", nullable=false)
  private Employer employer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "area_id")
  private Area area;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "compensation_from")
  private Integer compensationFrom;

  @Column(name = "compensation_to")
  private Integer  compensationTo;

  @Column(name = "compensation_gross")
  private Boolean compensationGross;

  @CreationTimestamp
  @Column(name = "creation_time", nullable = false, updatable = false)
  private LocalDateTime creationTime;

  @Column(name = "archiving_time")
  private LocalDateTime archivingTime;

  public Vacancy() {
  }

  public Vacancy(Employer employer) {
    this.employer = employer;
  }

  public void setArea(Area area) {
    this.area = area;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Employer getEmployer() {
    return employer;
  }

  public void setEmployer(Employer employer) {
    this.employer = employer;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCompensationFrom(Integer compensationFrom) {
    this.compensationFrom = compensationFrom;
  }

  public void setCompensationTo(Integer compensationTo) {
    this.compensationTo = compensationTo;
  }

  public LocalDateTime getArchivingTime() {
    return archivingTime;
  }

  public void setArchivingTime(LocalDateTime archivingTime) {
    this.archivingTime = archivingTime;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    Vacancy otherVacancy = (Vacancy) object;
    return  id.equals(otherVacancy.getId())
            && title.equals(otherVacancy.getTitle());
  }

  @Override
  public int hashCode() {
    int hash = id * id;
    hash = 31 * hash + (title == null ? 0 : title.hashCode());
    hash = 31 * hash + (description == null ? 0 : description.hashCode());
    return hash;
  }

}
