package com.siemens.mindsphere.iotmd.integtest.dao;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TimestampAttributeConverter implements AttributeConverter<Instant, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(Instant instant) {

        return Optional.ofNullable(instant)
                .map(Timestamp::from)
                .orElse(null);

    }

    @Override
    public Instant convertToEntityAttribute(Timestamp timestamp) {

        return Optional.ofNullable(timestamp)
                .map(inst -> Instant.ofEpochMilli(inst.getTime()))
                .orElse(null);

    }
}
