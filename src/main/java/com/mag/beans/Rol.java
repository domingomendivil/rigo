package com.mag.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Roles")
public class Rol {
	@Id
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("llamando equals");
		System.out.println("obj is "+obj);
		if (obj!=null){
			if (obj instanceof Rol){
				Rol rol = (Rol)obj;
				boolean res =  (rol.getName().equals(this.name));
				System.out.println("rol.getName() es:"+rol.getName());
				System.out.println("this.getName() es:"+this.name);
				System.out.println("equals es "+res);
				return res;
			}else{
				System.out.println("obj is not instance of Rol");
				return false;
			}
		}else{
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		System.out.println("hashcode "+this.name.hashCode());
		return this.name.hashCode();
	}
	
	
	
}
