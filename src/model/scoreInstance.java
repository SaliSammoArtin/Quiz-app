package model;

//Class to define how score instance looks
public class scoreInstance {
    private final int score;
    private final String nickname;
    private final String timestamp; // can also use LocalDateTime if needed


    public scoreInstance(int score, String nickname, String timestamp) {
        this.score = score;
        this.nickname = nickname;
        this.timestamp = timestamp;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Nickname: " + nickname + " | Score: " + score + " | Time: " + timestamp;
    }
}
