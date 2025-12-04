package model;

//Class to define how score instance looks
public class ScoreInstance {
    private final int score;
    private final String nickname;
    private final String timestamp; // Can also use LocalDateTime if needed


    public ScoreInstance(int score, String nickname, String timestamp) {
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
