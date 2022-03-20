package sortingvisualization.ui;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import sortingvisualization.common.SortTask;
import sortingvisualization.common.SwapItem;
import sortingvisualization.sorts.InsertionSort;
import sortingvisualization.sorts.SelectionSort;

public class GraphViewController implements Initializable {

    private final XYChart.Series<String, Integer> chartData = new XYChart.Series();
    private static final int ENTRY_LIMIT = 1000;
    private static final int INITIAL_WAIT_DELAY = 10_000;

    @FXML
    private BarChart<String, Integer> barChart;
    @FXML
    private Label lblComparison;
    @FXML
    private Label lblDatasetSize;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addData();
        System.out.println("Will start soring in " + INITIAL_WAIT_DELAY + "ms");
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    startSort();
                });
            }
        }, INITIAL_WAIT_DELAY);
    }

    private void addData() {
        Random random = new Random(System.currentTimeMillis());
        barChart.getData().setAll(chartData);
        for (int i = 0; i < ENTRY_LIMIT; i++) {
            int value = random.nextInt(100_000);
            chartData.getData().add(new XYChart.Data<>(String.valueOf(i + 1), value));
        }
        barChart.getYAxis().setTickMarkVisible(false);
        barChart.getXAxis().setTickMarkVisible(false);
    }

    private void startSort() {
        lblDatasetSize.setText("Array size: " + ENTRY_LIMIT);

        SortTask sortTask = new SelectionSort(chartData);
        Thread th = new Thread(sortTask);
        th.setDaemon(true);
        th.start();

        System.out.println("Sorting is started: " + sortTask.getClass().getName());
        sortTask.valueProperty().addListener((ObservableValue<? extends SwapItem> observable, SwapItem oldValue, SwapItem newValue) -> {
            sortTask.getSwapCode(newValue).run();
        });

        sortTask.messageProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            lblComparison.setText(newValue);
        });
    }

    private int getValueAt(int index) {
        return chartData.getData().get(index).getYValue();
    }

    private void setValueAt(int index, Integer value) {
        chartData.getData().set(index, new XYChart.Data<>(String.valueOf(index + 1), value));
    }

}
