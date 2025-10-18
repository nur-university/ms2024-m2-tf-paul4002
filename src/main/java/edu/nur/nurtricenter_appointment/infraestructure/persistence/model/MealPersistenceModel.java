package edu.nur.nurtricenter_appointment.infraestructure.persistence.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "meals")
public class MealPersistenceModel {

  @Id
  @GeneratedValue
  private UUID id;

  @Column(nullable = false)
  private String name;

  private String schedule;

  private Integer totalCalories;

  @ManyToOne
  @JoinColumn(name = "meal_plan_id")
  private MealPlanPersistenceModel mealPlan;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSchedule() {
    return schedule;
  }

  public void setSchedule(String schedule) {
    this.schedule = schedule;
  }

  public Integer getTotalCalories() {
    return totalCalories;
  }

  public void setTotalCalories(Integer totalCalories) {
    this.totalCalories = totalCalories;
  }

  public MealPlanPersistenceModel getMealPlan() {
    return mealPlan;
  }

  public void setMealPlan(MealPlanPersistenceModel mealPlan) {
      this.mealPlan = mealPlan;
  }
}
