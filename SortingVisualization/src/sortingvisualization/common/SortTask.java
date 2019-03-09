package sortingvisualization.common;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Villan
 */
public abstract class SortTask extends Task<SwapItem> {

    protected final XYChart.Series<String, Integer> chartData;
    protected final AtomicBoolean flag;
    protected long comparisonCount = 0;

    public SortTask(XYChart.Series<String, Integer> chartData) {
        this.chartData = chartData;
        this.flag = new AtomicBoolean(false);
    }

    @Override
    protected SwapItem call() throws Exception {
        try {
            doSorting();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return null;
    }

    public abstract Runnable getSwapCode(SwapItem swapItem);

    protected int getValueAt(int index) {
        return chartData.getData().get(index).getYValue();
    }

    protected void setValueAt(int index, Integer value) {
        chartData.getData().set(index, new XYChart.Data<>(String.valueOf(index + 1), value));
    }

    protected abstract void doSorting();

    protected void waitOnFlag() {
        flag.set(false);
        long val = System.currentTimeMillis();
        while (!flag.get()) {
            if ((System.currentTimeMillis() - val) > 500) {
                System.out.println("Locked");
                flag.set(true);
            }
        }
    }

    public void setFlag(boolean value) {
        flag.set(value);
    }

    protected void updateComparisonMessage() {
        updateMessage("Number of comparisons: " + comparisonCount);
    }
}
