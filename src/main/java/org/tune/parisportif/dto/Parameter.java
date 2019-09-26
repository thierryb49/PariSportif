package org.tune.parisportif.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Wither;

@Data @NoArgsConstructor @AllArgsConstructor @Wither @ToString
public class Parameter {
	private Long matchDay;
	private Long phaseId;
	private Long userId;
	private String season;

}
