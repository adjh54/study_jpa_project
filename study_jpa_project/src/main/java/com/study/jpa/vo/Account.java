package com.study.jpa.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * @Entity : 특정 DB와 매핑되는 값
 * @author JONGHOON
 *
 */
@Entity(name = "myAccount")
@Table(name = "Account")
@Getter
@Setter
public class Account {

	/**
	 * @Id : Primary Key 지정
	 * @GeneratedValue : primary Key 자동 생성(auto_increment) - DEFAULT : AUTO
	 */
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	private String password;

	@OneToMany(mappedBy = "owner")
	private Set<Study> studies = new HashSet<>();

	@Temporal(TemporalType.TIMESTAMP)
	private Date created = new Date();

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "home_street")) })
	private Address address;

	@Embeddable
	class Address {

		private String street;

		private String city;

		private String state;

		private String zipCode;
	}

	public void addStudy(Study study) {
		this.studies.add(study);
		study.setOwner(this);
	}

	public void removeStudy(Study study) {
		this.studies.remove(study);
		study.setOwner(null);
	}
}