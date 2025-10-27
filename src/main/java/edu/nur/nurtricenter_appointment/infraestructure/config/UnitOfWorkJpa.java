package edu.nur.nurtricenter_appointment.infraestructure.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.hibernate.Session;
// import org.hibernate.engine.spi.PersistenceContext;
import org.hibernate.engine.spi.SessionImplementor;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter_appointment.core.abstractions.AggregateRoot;
import edu.nur.nurtricenter_appointment.core.abstractions.DomainEvent;
import edu.nur.nurtricenter_appointment.core.abstractions.IUnitOfWork;
import edu.nur.nurtricenter_appointment.domain.appointments.Appointment;
import edu.nur.nurtricenter_appointment.infraestructure.persistence.domainModel.AppointmentEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class UnitOfWorkJpa implements IUnitOfWork {
  private final EntityManager em;
  private final Pipeline pipeline;
  private final Set<Appointment> registeredEntities = new HashSet<>();

  public UnitOfWorkJpa(EntityManager em, Pipeline pipeline) {
    this.em = em;
    this.pipeline = pipeline;
  }

  public void register(Appointment entity) {
    registeredEntities.add(entity);
  }

  @Override
  @Async
  @Transactional
  public CompletableFuture<Void> commitAsync() {
    this.em.flush();
    List<DomainEvent> domainEvents = registeredEntities.stream()
      .filter(e -> !e.getDomainEvents().isEmpty())
      .flatMap(e -> {
          List<DomainEvent> events = new ArrayList<>(e.getDomainEvents());
          e.clearDomainEvents();
          return events.stream();
      })
      .toList();
    // List<AppointmentEntity> ar = em.createQuery("from AppointmentEntity", AppointmentEntity.class).getResultList();
    // List<DomainEvent> domainEvents = ar.stream()
    //   .filter(e -> !e.getDomainEvents().isEmpty())
    //   .flatMap(e -> {
    //     List<DomainEvent> events = new ArrayList<>(e.getDomainEvents());
    //     e.clearDomainEvents();
    //     return events.stream();
    //   })
    //   .toList();
    for (DomainEvent domainEvent : domainEvents) {
      domainEvent.send(pipeline);
    }
    registeredEntities.clear();
    return CompletableFuture.completedFuture(null);
  }
}
