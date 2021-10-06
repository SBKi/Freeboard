package com.jcpdev.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
	private int idx;
	private int mref;
	private String name;
	private String password;
	private String content;
	private Timestamp wdate;
	private String ip;
}
