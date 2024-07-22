package com.example.easystay.core.report.log;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CrudEventListener {
    private static final Logger logger = LoggerFactory.getLogger(CrudEventListener.class);


    @PostPersist
    public void afterCreate(Object entity) {
        logger.info("Entity created: " + entity.toString());
    }

    @PostUpdate
    public void afterUpdate(Object entity) {
        logger.info("Entity updated: " + entity.toString());
    }

    @PostRemove
    public void afterDelete(Object entity) {
        logger.info("Entity deleted: " + entity.toString());
    }
}
