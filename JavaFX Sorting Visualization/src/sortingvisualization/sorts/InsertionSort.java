package sortingvisualization.sorts;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.XYChart;
import sortingvisualization.common.SortTask;
import sortingvisualization.common.SwapItem;

/**
 *
 * @author Villan
 */
public class InsertionSort extends SortTask {

    public InsertionSort(XYChart.Series<String, Integer> chartData) {
        super(chartData);
    }

    @Override
    protected void doSorting() {
        int n = chartData.getData().size();
        int i, key, j;
        for (i = 1; i < n; i++) {
            key = getValueAt(i);
            j = i - 1;
            comparisonCount += 1;
            while (j >= 0 && getValueAt(j) > key) {
                SwapItem swapItem = new SwapItem(chartData.getData().get(j), j + 1);
                swapItem.setSecondIndex(0);
                updateValue(swapItem);
                comparisonCount += 1;
                updateComparisonMessage();
                waitOnFlag();
                j = j - 1;
                            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(InsertionSort.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            SwapItem swapItem = new SwapItem(null, j + 1);
            swapItem.setSecondIndex(1);
            swapItem.setRawValue(key);
            updateValue(swapItem);
            waitOnFlag();
        }
    }

    @Override
    public Runnable getSwapCode(SwapItem swapItem) {
        return () -> {
            if (swapItem != null) {
                if (swapItem.getSecondIndex() == 0) {
                    setValueAt(swapItem.getOriginalIndex(), swapItem.getItemToSwap().getYValue());
                } else {
                    setValueAt(swapItem.getOriginalIndex(), swapItem.getRawValue());
                }
            }
            flag.set(true);
        };
    }
}
