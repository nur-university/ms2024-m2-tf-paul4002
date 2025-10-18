package edu.nur.nurtricenter_appointment.infraestructure.persistence.model;

import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "diagnosis")
public class DiagnosisPersistenceModel {

  @Id
  @GeneratedValue
  private UUID id;

  @Column(nullable = false)
  private String description;

  private String nutritionalState;

  private String associatedRisks;

  private String recommendations;

  private String goals;

  private String comments;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAssociatedRisks() {
    return associatedRisks;
  }

  public void setAssociatedRisks(String associatedRisks) {
    this.associatedRisks = associatedRisks;
  }

  public String getRecommendations() {
    return recommendations;
  }

  public void setRecommendations(String recommendations) {
    this.recommendations = recommendations;
  }

  public String getGoals() {
    return goals;
  }

  public void setGoals(String goals) {
    this.goals = goals;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getNutritionalState() {
    return nutritionalState;
  }

  public void setNutritionalState(String nutritionalState) {
    this.nutritionalState = nutritionalState;
  }
  
}
