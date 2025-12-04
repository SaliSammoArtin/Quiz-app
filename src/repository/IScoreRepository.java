package repository;

import model.scoreInstance;

import java.util.List;

//Interface for repository, in case we choose to change how we save the scores later
public interface IScoreRepository {
    void saveScore(int score, String userNickname) throws Exception; //saves a score and nickname

    List<scoreInstance> loadScore() throws Exception; //loads score, nickname and timestamp as a List of scoreInstance type
}
