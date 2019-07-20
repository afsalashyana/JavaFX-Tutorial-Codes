package letterwriter.mainview;

import letterwriter.message.MessageParser;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.util.Duration;
import letterwriter.constants.Constants;

/**
 *
 * @author Villan
 */
public class MainViewController implements Initializable {

    private Timeline timeline;
    private MessageParser messageParser = new MessageParser();
    private Timer timer = new Timer();

    @FXML
    private TextArea displayField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(Constants.TEXT_INTERVAL), (ActionEvent event) -> {
            handleText();
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void handleText() {
        Character next = messageParser.getNext();
        if (null == next) {
            stopAnimation();
            return;
        } else switch (next) {
            case '$':
                sleep(Constants.THINK_INTERVAL);
                return;
            case '-':
                int currentLength = displayField.getLength();
                displayField.setText(displayField.getText().substring(0, currentLength - 1));
                sleep(Constants.TEXT_INTERVAL);
                return;
            default:
                break;
        }
        displayField.appendText(String.valueOf(next));
        sleep(Constants.TEXT_INTERVAL);
    }

    private void stopAnimation() {
        timeline.stop();
    }

    private void sleep(Long time) {
        timeline.pause();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeline.play();
            }
        }, time);
    }

}
