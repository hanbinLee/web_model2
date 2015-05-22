package replyModel;

public class ReplyDto {
	private int bunho;				// 자동증가번호
	private int board_number;		// 부모 글번호
	private String line_reply;		// 답글
	
	public int getBunho() {
		return bunho;
	}
	public void setBunho(int bunho) {
		this.bunho = bunho;
	}
	public int getBoard_number() {
		return board_number;
	}
	public void setBoard_number(int board_number) {
		this.board_number = board_number;
	}
	public String getLine_reply() {
		return line_reply;
	}
	public void setLine_reply(String line_reply) {
		this.line_reply = line_reply;
	}
}
