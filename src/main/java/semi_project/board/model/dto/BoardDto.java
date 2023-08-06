package semi_project.board.model.dto;

public class BoardDto {
//	IDX         NOT NULL NUMBER         
//	TITLE      NOT NULL VARCHAR2(300)  
//	CONTENT             VARCHAR2(4000) 
//	WRITE_DATE NOT NULL TIMESTAMP(6)   
//	MID         NOT NULL VARCHAR2(20)   
//	BREF        NOT NULL NUMBER         
//	BRE_LEVEL   NOT NULL NUMBER         
//	BRE_STEP    NOT NULL NUMBER
	
	private int idx;
	private String title;
	private String content;
	private String write_date;
	private String mid;
	private int bref;
	private int breLevel;
	private int breStep;
	
	public BoardDto() {
	}
	
	// selectOne dao --> controll --> view
	public BoardDto(int idx, String title, String content, String write_date, String mid, int bref, int breLevel,
			int breStep) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.write_date = write_date;
		this.mid = mid;
		this.bref = bref;
		this.breLevel = breLevel;
		this.breStep = breStep;
	}
	
	//selectList(메인화면)엔 (content(내용) 없음) dao --> controll --> view
	public BoardDto(int idx, String title, String write_date, String mid, int bref, int breLevel, int breStep) {
		this.idx = idx;
		this.title = title;
		//content 없음
		this.write_date = write_date;
		this.mid = mid;
		this.bref = bref;
		this.breLevel = breLevel;
		this.breStep = breStep;
	}
	
	//원본 글 등록 view -> controller -> dao
	public BoardDto(String title, String content, String mid) {		
		this.title = title;
		this.content = content;
		this.mid = mid;
	}

	// 답글 등록 view -> controller -> dao
	public BoardDto(int idx, String title, String content, String mid) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "BoardDto [idx=" + idx + ", title=" + title + ", content=" + content + ", write_date=" + write_date
				+ ", mid=" + mid + ", bref=" + bref + ", breLevel=" + breLevel + ", breStep=" + breStep + "]";
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getBref() {
		return bref;
	}

	public void setBref(int bref) {
		this.bref = bref;
	}

	public int getBreLevel() {
		return breLevel;
	}

	public void setBreLevel(int breLevel) {
		this.breLevel = breLevel;
	}

	public int getBreStep() {
		return breStep;
	}

	public void setBreStep(int breStep) {
		this.breStep = breStep;
	}
	
}
