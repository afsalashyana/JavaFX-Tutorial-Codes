package sortingvisualization.sorts;

import javafx.scene.chart.XYChart;
import sortingvisualization.common.SortTask;
import sortingvisualization.common.SwapItem;

/**
 *
 * @author Villan
 */
public class BubbleSort extends SortTask {

    public BubbleSort(XYChart.Series<String, Integer> chartData) {
        super(chartData);
    }

    @Override
    protected void doSorting() {
        int n = chartData.getData().size();
        for (int i = 0; i < n; i++) {
            comparisonCount += 1;
            for (int j = 1; j < (n - i); j++) {
                if (getValueAt(j - 1) > getValueAt(j)) {
                    SwapItem swapItem = new SwapItem(chartData.getData().get(j - 1), j);
                    updateValue(swapItem);
                    comparisonCount += 2;
                    updateComparisonMessage();
                    waitOnFlag();
                }
            }
            System.out.println("Completed index: " + i);
        }
    }

    @Override
    public Runnable getSwapCode(SwapItem swapItem) {
        return () -> {
            try {
                if (swapItem != null) {
                    int j = swapItem.getOriginalIndex();
                    setValueAt(j - 1, getValueAt(j));
                    setValueAt(j, swapItem.getItemToSwap().getYValue());
                }
                flag.set(true);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        };
    }
}
