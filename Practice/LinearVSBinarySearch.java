public class LinearVSBinarySearch {
    public static void main(String[] args) throws Exception {
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};

        int key = 10;
        System.out.print("Linear Search Result: ");
        System.out.println("Linear Search Index: " + linearSearch(array, key));

        System.out.print("Binary Search Results: ");
        System.out.println("Binary Search Index: " + ascendingBinarySearch(array, key));
    }

    public static <T> int linearSearch(T[] array, T key) {
        // To compare, we'll use a comparison counter
        int comparisonCounter = 0;

        int foundIndex = -1;
        for(int i = 0; i < array.length; i++) {
            comparisonCounter++;
            if (((Comparable<T>)key).compareTo(array[i]) == 0) {
                foundIndex = i;
                break;
            }
            
        }
        System.out.print(String.format("Comparisons: %s, ", comparisonCounter));
        return foundIndex; //since the key wasn't found, return an invalid index
    }

    public static <T> int ascendingBinarySearch(T[] array, T key) {
        // To compare, we'll use a comparison counter
        int comparisonCounter = 0;

        int left = 0;
        int right = array.length - 1;

        int mid = (left + right) / 2;

        boolean endOfSearch = true;
        int foundIndex = -1;
        while (endOfSearch) {
            comparisonCounter++;

            // guard if-clause to make sure we haven't reached the end of the array
            if (left == right) {
                if (((Comparable<T>)key).compareTo(array[left]) == 0) {
                    foundIndex = left;
                    break;
                }
                endOfSearch = false;
            }

            if (((Comparable<T>)key).compareTo(array[mid]) == 0) {
                foundIndex = mid;
                break;
            } else if (((Comparable<T>)key).compareTo(array[mid]) > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
                
            }
            mid = (left + right) / 2;
        }
        System.out.print(String.format("Comparisons: %s, ", comparisonCounter));
        return foundIndex;

    }
}
