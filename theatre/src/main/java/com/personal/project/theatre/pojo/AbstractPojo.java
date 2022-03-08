package com.personal.project.theatre.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import java.time.ZonedDateTime;

@MappedSuperclass
@Getter
@Setter
public class AbstractPojo {

	private ZonedDateTime createdAt = ZonedDateTime.now();

	private ZonedDateTime modifiedAt = ZonedDateTime.now();

	@Version
	private Long version;

	@PreUpdate
	public void setModifiedAt() {
		this.modifiedAt = ZonedDateTime.now();
	}
}