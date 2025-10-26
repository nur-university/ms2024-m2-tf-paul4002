package edu.nur.nurtricenter_appointment.infraestructure.persistence.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.nur.nurtricenter_appointment.infraestructure.persistence.persistenceModel.AppointmentPersistenceModel;

public interface AppointmentCrudRepository extends CrudRepository<AppointmentPersistenceModel, UUID>  {
  @Query("""
      SELECT a
      FROM AppointmentPersistenceModel a
      WHERE a.nutritionistId = :nutritionistId
      AND DATE(a.scheduledDate) = :date
  """)
  List<AppointmentPersistenceModel> findByNutritionistAndDate(
    @Param("nutritionistId") UUID nutritionistId,
    @Param("date") LocalDate date
  );

  @Query("""
        SELECT CASE WHEN COUNT(a) > 0 THEN TRUE ELSE FALSE END
        FROM AppointmentPersistenceModel a
        WHERE a.nutritionistId = :nutritionistId
          AND a.scheduledDate BETWEEN :startDate AND :endDate
    """)
    boolean existsAppointmentNearTime(
            @Param("nutritionistId") UUID nutritionistId,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
}
