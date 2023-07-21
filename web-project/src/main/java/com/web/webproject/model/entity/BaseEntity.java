package com.web.webproject.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EntityListeners;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;

/**
 * The type Base entity.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class BaseEntity {

  /**
   * The Created by.
   */
  @CreatedBy
  @Column(name = "created_by", updatable = false)
  private String createdBy;

  /**
   * The Created date.
   */
  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(pattern = "yyyy/MM/dd")
  @Column(name = "created_date", updatable = false)
  private Date createdDate;

  /**
   * The Last updated by.
   */
  @LastModifiedBy
  @Column(name = "last_updated_by")
  private String lastUpdatedBy;

  /**
   * The Last updated date.
   */
  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(pattern = "yyyy/MM/dd")
  @Column(name = "last_updated_date")
  private Date lastUpdatedDate;

}
