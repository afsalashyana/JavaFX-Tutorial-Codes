package sortingvisualization.sorts;

import javafx.scene.chart.XYChart;
import sortingvisualization.common.SortTask;
import sortingvisualization.common.SwapItem;

/**
 *
 * @author Villan
 */
public class SelectionSort extends SortTask {

    public SelectionSort(XYChart.Series<String, Integer> chartData) {
        super(chartData);
    }

    @Override
    protected void doSorting() {
        int n = chartData.getData().size();
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            comparisonCount += 1;
            for (int j = i + 1; j < n; j++) {
                if (getValueAt(j) < getValueAt(min_idx)) {
                    min_idx = j;
                }
                comparisonCount += 1;
                updateComparisonMessage();
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            SwapItem swapItem = new SwapItem(chartData.getData().get(min_idx), min_idx);
            swapItem.setSecondIndex(i);
            updateValue(swapItem);
            waitOnFlag();
        }
    }

    @Override
    public Runnable getSwapCode(SwapItem swapItem) {
        return () -> {
            if (swapItem != null) {
                int min_idx = swapItem.getOriginalIndex();
                int i = swapItem.getSecondIndex();
                setValueAt(min_idx, getValueAt(i));
                setValueAt(i, swapItem.getItemToSwap().getYValue());
            }
            flag.set(true);
        };
    }
}
