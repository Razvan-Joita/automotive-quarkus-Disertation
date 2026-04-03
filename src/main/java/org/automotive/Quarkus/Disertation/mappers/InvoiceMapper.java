package org.automotive.Quarkus.Disertation.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.automotive.Quarkus.Disertation.dtos.InvoiceDTO;
import org.automotive.Quarkus.Disertation.models.Invoice;

@ApplicationScoped
public class InvoiceMapper {
    public InvoiceDTO toDto(Invoice entity) {
        InvoiceDTO dto = new InvoiceDTO();
        dto.id = entity.id;
        dto.amount = entity.amount;
        dto.serviceRecordId = entity.serviceRecord != null ? entity.serviceRecord.id : null;
        return dto;
    }

    public Invoice toEntity(InvoiceDTO dto) {
        Invoice entity = new Invoice();
        entity.id = dto.id;
        entity.amount = dto.amount;
        return entity;
    }
}