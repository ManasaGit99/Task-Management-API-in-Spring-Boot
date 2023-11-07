package com.spring.hibernate.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {
		@Id
		@Column(name="id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name="title")
		private String title;
		
		@Column(name="completed")
		private String completed;
		
		public Task(){
			
		}

		public Task(String title, String completed) {
			super();
			this.title = title;
			this.completed = completed;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getCompleted() {
			return completed;
		}

		public void setCompleted(String completed) {
			this.completed = completed;
		}

		@Override
		public String toString() {
			return "Task [id=" + id + ", title=" + title + ", completed=" + completed + "]";
		}
		
}
