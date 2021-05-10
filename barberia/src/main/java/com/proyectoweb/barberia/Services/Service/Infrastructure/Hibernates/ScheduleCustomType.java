package com.proyectoweb.barberia.Services.Service.Infrastructure.Hibernates;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectoweb.barberia.Products.CarritoCompra.Domain.ValueObjects.ProductDetails;
import com.proyectoweb.barberia.Services.Schedule.Domain.Schedule;
import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleDate;
import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleOption;
import com.proyectoweb.barberia.Shared.Domain.Schedule.ScheduleId;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ScheduleCustomType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[]{Types.LONGNVARCHAR};
    }

    @Override
    public Class returnedClass() {
        return List.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x,y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        List<Schedule> response = null;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Optional<String> value = Optional.ofNullable(rs.getString(names[0]));
            if(value.isPresent()){
                List<HashMap<String, Object>> objects = new ObjectMapper().readValue(value.get(), List.class);
                response = objects.stream().map(schedule ->
                        new Schedule(new ScheduleId((String) schedule.get("schedule_id")),
                                new ServiceId((String) schedule.get("service_id")),
                                new ScheduleDate(Timestamp.valueOf((String) schedule.get("datetime_start"))),
                                new ScheduleOption((String) schedule.get("type"))
                                )).collect(Collectors.toList());
            }
        } catch (Exception e){
            throw new HibernateException("Error at reading map", e);
        }
        return Optional.ofNullable(response);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        Optional<List<Schedule>> schedules = (value == null) ? Optional.empty() : (Optional<List<Schedule>>) value;
        try {
            if(schedules.isEmpty()){
                st.setNull(index, Types.VARCHAR);
            } else {
                ObjectMapper mapper = new ObjectMapper();
                List<HashMap<String, Object>> objects = schedules.get().stream().map(schedule -> schedule.data()).collect(Collectors.toList());
                String serializedList = mapper.writeValueAsString(objects).replace("\\", "");
                st.setString(index, serializedList);
            }
        } catch (Exception e){
            throw new HibernateException("Exception serializing value " + value, e);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return null;
    }
}
