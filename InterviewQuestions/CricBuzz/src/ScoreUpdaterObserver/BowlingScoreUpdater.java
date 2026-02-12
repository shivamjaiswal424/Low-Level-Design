package ScoreUpdaterObserver;

import Innings.Ball;
import Innings.BallType;
import Innings.RunType;

public class BowlingScoreUpdater implements ScoreUpdaterObserver {

    @Override
    public void update(Ball ball) {
        if (ball.getBallNumber() == 6 && ball.getBallType() == BallType.NORMAL) {
            ball.getBowledBy().getBowlingScoreCard().totalOverDeliver++;
        }

        if (RunType.ONE == ball.runType) {
            ball.getBowledBy().getBowlingScoreCard().runsGiven += 1;
        } else if (RunType.TWO == ball.runType) {
            ball.bowledBy.getBowlingScoreCard().runsGiven += 2;
        } else if (RunType.FOUR == ball.runType) {
            ball.bowledBy.getBowlingScoreCard().runsGiven += 4;
        } else if (RunType.SIX == ball.runType) {
            ball.bowledBy.getBowlingScoreCard().runsGiven += 6;
        }

        if (ball.wicket != null) {
            ball.bowledBy.getBowlingScoreCard().wicketTaken++;
        }

        if (ball.ballType == BallType.NOBALL) {
            ball.bowledBy.getBowlingScoreCard().noBallCount++;
        }

        if (ball.ballType == BallType.WIDEBALL) {
            ball.bowledBy.getBowlingScoreCard().wideBallCount++;
        }

    }
}
