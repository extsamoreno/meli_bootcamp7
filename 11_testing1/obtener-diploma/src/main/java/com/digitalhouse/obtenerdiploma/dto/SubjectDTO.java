package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SubjectDTO {

  @NotNull( message="Name cannot be null")
  @Size(max = 50, message = "Max size 50 character")
  private String subject;

  @NotNull
  @Min(value = 1, message = "note valid min is 1")
  @Max(value = 10, message = "Max value note is 10")
  private Integer note;

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Integer getNote() {
    return note;
  }

  public void setNote(Integer note) {
    this.note = note;
  }

}
