package semi_project.member.dto;

public class MemberDto {

	private String mid;
	private String mpwd;
	private String mname;
	private String memail;
	
	public MemberDto() {}

	public MemberDto(String mid, String mpwd) {
		this.mid = mid;
		this.mpwd = mpwd;
	}

	public MemberDto(String mid, String mname, String memail) {
		this.mid = mid;
		this.mname = mname;
		this.memail = memail;
	}

	@Override
	public String toString() {
		return "MemberDto [mid=" + mid + ", mpwd=" + mpwd + ", mname=" + mname + "]";
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}
	
	public String getMemail() {
		return memail;
	}
	
	public void setMemail(String memail) {
		this.memail = memail;
	}

	
}
