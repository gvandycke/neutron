package com.greggvandycke.neutron.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="movies")
@EntityListeners(AuditingEntityListener.class)
public class Movie extends Auditable<String> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String title;
	private int length;
	private String url;

	@ManyToMany(mappedBy = "favorites", fetch = FetchType.LAZY)
	private List<User> users = new ArrayList<>();

	public Movie(String title, int length, String url) {
		this.title = title;
		this.length = length;
		this.url = url;
	}
}