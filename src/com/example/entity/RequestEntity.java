package com.example.entity;

public class RequestEntity {
	
	private String method;
	private JsonRequest jr;
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public JsonRequest getJr() {
		return jr;
	}

	public void setJr(JsonRequest jr) {
		this.jr = jr;
	}

	class JsonRequest{
		private String count;
		private String page;
		private String cid;
		private String coid;
		private String did;
		private String phonenumber;
		private String CityId;
		public String getCount() {
			return count;
		}
		public void setCount(String count) {
			this.count = count;
		}
		public String getPage() {
			return page;
		}
		public void setPage(String page) {
			this.page = page;
		}
		public String getCid() {
			return cid;
		}
		public void setCid(String cid) {
			this.cid = cid;
		}
		public String getCoid() {
			return coid;
		}
		public void setCoid(String coid) {
			this.coid = coid;
		}
		public String getDid() {
			return did;
		}
		public void setDid(String did) {
			this.did = did;
		}
		public String getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}
		public String getCityId() {
			return CityId;
		}
		public void setCityId(String cityId) {
			CityId = cityId;
		}
	}

}
