package com.tca.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Engine")
public class Engine 
{

		@Id
		private Integer eid;
		private String etype;
		private String esize;
		
		@OneToOne(mappedBy="engine",cascade=CascadeType.ALL)
		private Car car;

		public Integer getEid() {
			return eid;
		}

		public void setEid(Integer eid) {
			this.eid = eid;
		}

		public String getEtype() {
			return etype;
		}

		public void setEtype(String etype) {
			this.etype = etype;
		}

		public String getEsize() {
			return esize;
		}

		public void setEsize(String esize) {
			this.esize = esize;
		}

		public Car getCar() {
			return car;
		}

		public void setCar(Car car) {
			this.car = car;
		}
		
		
		
}
