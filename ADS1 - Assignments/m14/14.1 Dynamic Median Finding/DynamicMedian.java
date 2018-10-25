/**
 *the class is for performing dynamic median.
 */
class DynamicMedian {
    /**
     *the object to access of minheap.
     */
    private MinPQ<Double> minObj;
    /**
     *the object to access of maxheap.
     */
    private MaxPQ<Double> maxObj;
    /**
     *the constructor for initializing.
     */
    DynamicMedian() {
        minObj = new MinPQ<Double>();
        maxObj = new MaxPQ<Double>();
    }
    /**
     * Time complexity is O(logN).
     * the method will insert the element
     * to minheap.
     * @param      item  The item
     */
    public void insertAtMin(final double item) {
        minObj.insert(item);
    }
    /**
     * Time complexity is O(logN).
     * the method will insert the element
     * to maxheap.
     * @param      item  The item
     */
    public void insertAtMax(final double item) {
        maxObj.insert(item);
    }
    /**
     * Time complexity is O(1).
     * this method gets the minimum element.
     * from minheap.
     * @return     The minimum.
     */
    public double getMin() {
        return minObj.min();
    }
    /**
     * Time complexity is O(1).
     * this method gets the maximum element.
     * from maxheap.
     * @return     The minimum.
     */
    public double getMax() {
        return maxObj.max();
    }
    /**
     * Time complexity is O(logN).
     * this method delete the maximum element.
     * from maxheap.
     * @return     The minimum.
     */
    public double delMax() {
        return maxObj.delMax();
    }
    /**
     * Time complexity is O(logN).
     * this method delete the minimum element.
     * from maxheap.
     * @return     The minimum.
     */
    public double delMin() {
        return minObj.delMin();
    }
    /**
     * Time complexity is O(1).
     * gets the size of minheap.
     *
     * @return     The minimum size.
     */
    public int getMinSize() {
        return minObj.size();
    }
    /**
     * Time complexity is O(1).
     * Gets the maximum size of maxheap.
     *
     * @return     The maximum size.
     */
    public int getMaxSize() {
        return maxObj.size();
    }
}
