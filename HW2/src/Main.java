public class Main {
    public static void main(String[] args) throws MyArraySizeException,MyArrayDataException {
        String array[][] = { { "2", "3", "4", "2" }, { "4", "1", "2", "3" },
                { "4", "2", "7", "3" }, { "2", "3", "4", "5" } };
        arrayCheck(array);
    }

    public static void arrayCheck(String array[][]) throws MyArraySizeException,MyArrayDataException {
        if (array.length != 4)
            throw new MyArraySizeException();

        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4)
                throw new MyArraySizeException();
        }

        int[][] array2 = new int[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    array2[i][j] = Integer.parseInt(array[i][j]);
                } catch (Exception e) {
                    throw new  MyArrayDataException();
                }
                System.out.println(array2[i][j]);
            }}
            int sumArray = 0;
        for (int i=0; i<array.length; i++){
            for(int j=0; j<array2.length; j++)
                sumArray = sumArray + array2[i][j];
            }
            System.out.println("Сумма массива: " + sumArray);


    }

    public static class MyArraySizeException extends Exception {
    }
    public static class  MyArrayDataException extends Exception{}
}