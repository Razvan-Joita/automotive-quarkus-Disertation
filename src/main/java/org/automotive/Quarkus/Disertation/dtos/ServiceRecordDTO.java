package org.automotive.Quarkus.Disertation.dtos;

import java.time.LocalDate;
import java.util.List;

public class ServiceRecordDTO {
    public Long id;
    public String description;
    public LocalDate date;
    public Long vehicleId;
    public Long mechanicId;
    public List<Long> partIds;
}
