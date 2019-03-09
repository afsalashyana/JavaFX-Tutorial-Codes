package sortingvisualization.common;

import javafx.scene.chart.XYChart;

/**
 * @author Villan
 */
public class SwapItem {

    private XYChart.Data<String, Integer> itemToSwap;
    private int originalIndex;
    private int secondIndex;
    private int rawValue;

    public SwapItem(XYChart.Data<String, Integer> itemToSwap, int originalIndex) {
        this.itemToSwap = itemToSwap;
        this.originalIndex = originalIndex;
    }

    public void setSecondIndex(int secondIndex) {
        this.secondIndex = secondIndex;
    }

    public int getRawValue() {
        return rawValue;
    }

    public void setRawValue(int rawValue) {
        this.rawValue = rawValue;
    }

    public int getSecondIndex() {
        return secondIndex;
    }

    public XYChart.Data<String, Integer> getItemToSwap() {
        return itemToSwap;
    }

    public int getOriginalIndex() {
        return originalIndex;
    }
}
