package com.proyectoweb.barberia.Services.Schedule.Infrastructure.Hibernates;


import com.proyectoweb.barberia.Services.Schedule.Domain.Ports.ScheduleRepository;
import com.proyectoweb.barberia.Services.Schedule.Domain.Schedule;
import com.proyectoweb.barberia.Services.Service.Domain.Service;
import com.proyectoweb.barberia.Shared.Domain.Schedule.ScheduleId;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateScheduleRepository implements ScheduleRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Schedule> aggregateClass;

    public HibernateScheduleRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Schedule.class;
    }

    @Override
    public void save(Schedule schedule) {
        sessionFactory.getCurrentSession().save(schedule);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public void update(Schedule schedule) {
        this.sessionFactory.getCurrentSession().update(schedule);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<Schedule> find(String scheduleId) {
        ScheduleId id = new ScheduleId(scheduleId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public Optional<List<Schedule>> findAll() {

        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Schedule> criteriaQuery = criteriaBuilder.createQuery(Schedule.class);
        Root<Schedule> root = criteriaQuery.from(Schedule.class);
        criteriaQuery.select(root);
        Query<Schedule> query = session.createQuery(criteriaQuery);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public void delete(Schedule schedule) {
        sessionFactory.getCurrentSession().delete(schedule);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }
}
