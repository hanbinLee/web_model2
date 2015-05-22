package replyModel;

public class ReplyDto {
	private int bunho;
	private int board_number;
	private String line_reply;
	
	public int getBunho() {
		return bunho;
	}
	public int getBoard_number() {
		return board_number;
	}
	public String getLine_reply() {
		return line_reply;
	}
	public void setBunho(int bunho) {
		this.bunho = bunho;
	}
	public void setBoard_number(int board_number) {
		this.board_number = board_number;
	}
	public void setLine_reply(String line_reply) {
		this.line_reply = line_reply;
	}	
}
