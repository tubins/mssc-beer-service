package com.tubz.msscbeerservice.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Date mapper class.
 */
@Component
public class DateMapper {

    /**
     * Conver @{@link Timestamp} to @{@link OffsetDateTime}
     *
     * @param ts time stamp.
     * @return instance of {@link OffsetDateTime}.
     */
    public OffsetDateTime asOffsetDateTime(Timestamp ts) {
        if (ts != null) {
            return OffsetDateTime.of(ts.toLocalDateTime().getYear(), ts.toLocalDateTime().getMonthValue(),
                    ts.toLocalDateTime().getDayOfMonth(), ts.toLocalDateTime().getHour(), ts.toLocalDateTime().getMinute(),
                    ts.toLocalDateTime().getSecond(), ts.toLocalDateTime().getNano(), ZoneOffset.UTC);
        } else {
            return null;
        }
    }

    /**
     * Conver @{@link OffsetDateTime} to {@link Timestamp}.
     *
     * @param offsetDateTime instance of @{@link OffsetDateTime}
     * @return instance of @{@link Timestamp}.
     */
    public Timestamp asTimestamp(OffsetDateTime offsetDateTime) {
        if (offsetDateTime != null) {
            return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        } else {
            return null;
        }
    }
}
