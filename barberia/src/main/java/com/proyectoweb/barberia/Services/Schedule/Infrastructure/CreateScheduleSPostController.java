package com.proyectoweb.barberia.Services.Schedule.Infrastructure;

import com.proyectoweb.barberia.Services.Schedule.Application.ScheduleCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;

@RestController
@RequestMapping(value = "/schedule")
public class CreateScheduleSPostController {

    @Autowired
    private ScheduleCreator scheduleCreator;

    @PostMapping(value = "create")
    public ResponseEntity execute(@RequestBody Request request){
        scheduleCreator.execute(request.getSchedule_id(), request.getDatetime_start(),request.getService_id(),request.getType());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    static class Request{
        private String schedule_id;
        private String datetime_start;
        private String service_id;
        private char type;

        public String getSchedule_id() {
            return schedule_id;
        }

        public void setSchedule_id(String schedule_id) {
            this.schedule_id = schedule_id;
        }

        public String getDatetime_start() {
            return datetime_start;
        }

        public void setDatetime_start(String datetime_start) {
            this.datetime_start = datetime_start;
        }

        public String getService_id() {
            return service_id;
        }

        public void setService_id(String service_id) {
            this.service_id = service_id;
        }

        public char getType() {
            return type;
        }

        public void setType(char type) {
            this.type = type;
        }
    }
}