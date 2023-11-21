package com.example.redis.cache.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Source {

	private String version;
	private String connector;
	private String name;
	private String ts_ms;
	private String snapshot;
	private String db;
	private String sequence;
	private String table;
	private String server_id;
	private String gtid;
	private String file;
	private String pos;
	private Integer row;
	private Integer thread;
	private String query;

}
