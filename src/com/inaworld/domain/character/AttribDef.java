package com.inaworld.domain.character; 

public class AttribDef {
	private final String name;
	private final int min;
	private final int max;

	private AttribDef(Builder builder) {
		this.name = new String(builder.name);
		this.min = builder.min;
		this.max = builder.max;
	}

	public String getName() {
		return name;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public static class Builder {
		private String name;
		private int min;
		private int max;
		
		public Builder () {
		}
		
		public Builder name (String name) {
			assert(name)!=null;
			
			this.name = name;
			return this;
		}
		
		public Builder min(int min) {
			this.min = min;
			return this ;
		}
		public Builder max(int max) {
			this.max = max;
			return this ;
		}
		
		public AttribDef build() {
			return new AttribDef(this);
		}

	}
	
	public String toString() {
		return "name:" + name + " min:" + min + " max:" + max;   
	}
	
	public static void main(String[] args) {
		
		AttribDef att = new AttribDef.Builder().name("strength").min(6).max(36).build();
		System.out.println(att.getName() + att.getMin() + att.getMax());
	}
}