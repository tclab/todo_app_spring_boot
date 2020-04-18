package com.tclab.restfulwebservice.ent;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

  private long id;
  private String username;
  private String description;
  private Date targetDate;
  private boolean isDone;

}
