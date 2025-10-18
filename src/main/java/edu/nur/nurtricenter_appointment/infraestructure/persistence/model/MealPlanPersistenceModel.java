package edu.nur.nurtricenter_appointment.infraestructure.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "mealplans")
public class MealPlanPersistenceModel {

  @Id
  @GeneratedValue
  private UUID id;

  @Column(nullable = false)
  private String generalDescripcion;

  @Column(nullable = false)
  private String nutritionalGoal;

  private Date startDate;

  private Date endDate;

  private String restrictions;

  private UUID appointmentId;

  @OneToMany(
    mappedBy = "mealPlan",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<MealPersistenceModel> meals = new ArrayList<>();

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getGeneralDescripcion() {
    return generalDescripcion;
  }

  public void setGeneralDescripcion(String generalDescripcion) {
    this.generalDescripcion = generalDescripcion;
  }

  public String getNutritionalGoal() {
    return nutritionalGoal;
  }

  public void setNutritionalGoal(String nutritionalGoal) {
    this.nutritionalGoal = nutritionalGoal;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getRestrictions() {
    return restrictions;
  }

  public void setRestrictions(String restrictions) {
    this.restrictions = restrictions;
  }

  public UUID getAppointmentId() {
    return appointmentId;
  }

  public void setAppointmentId(UUID appointmentId) {
    this.appointmentId = appointmentId;
  }

  public List<MealPersistenceModel> getMeals() {
    return meals;
  }

  public void setMeals(List<MealPersistenceModel> meals) {
    this.meals = meals;
  }
}
