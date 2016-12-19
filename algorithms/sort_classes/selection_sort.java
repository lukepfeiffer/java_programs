class SelectionSort{

  // Descending Order!

  public static void main(String args[]){
    int i, j, first, temp;
    int length = 15;
    int[] array = new int[length];

    System.out.print("Original array: ");

    for(i = 0; i < length; ++i){
      array[i] = ((int)(Math.random()*100 + 1));
      System.out.print(array[i] + " ");
    }

    for (i = length - 1; i > 0; --i) {
    first = 0;

      for(j = 1; j <= i; ++j) {
        if(array[j] < array[first] ) {
          first = j;
        }
        temp = array[first];
        array[first] = array[i];
        array[i] = temp;
      }

    }

    System.out.println();
    System.out.print("Newly sorted array: ");

    for(i = 0; i < length; ++i){
      System.out.print(array[i] + " ");
    }

  }
}
