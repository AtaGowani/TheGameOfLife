import java.util.Scanner;

/*
Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
Any live cell with two or three live neighbours lives on to the next generation.
Any live cell with more than three live neighbours dies, as if by overpopulation.
Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 */

public class TheGameOfLife {

    public static void main(String[] args) {
      char[][] earthV2 = new char[10][10];
      char[][] newEarthV2 = new char[10][10];
      int numberOfIterations = 0;

      int randomNumber;

      // On the first go, initialize the array randomly
      for (int i = 0; i < earthV2.length; i++){
        for (int j = 0; j < earthV2[i].length; j++){
          randomNumber = (int)(Math.random() * 10);
          if (randomNumber <= 5) {
            earthV2[i][j] = '.';
          } else {
            earthV2[i][j] = ' ';
          }
        }
      }

      Scanner userInput = new Scanner(System.in);

      System.out.print("How many generations would you like to run: ");
      int numberOfGenerations = userInput.nextInt();

      do{
        numberOfIterations++;
        int neighborCount = 0;

        // Print out the result of the generation that just passed
        for (int i = 0; i < earthV2.length; i++) {
          for (int j = 0; j < earthV2[i].length; j++) {
            System.out.format("%c", earthV2[i][j]);
          }
          System.out.println(' ');
        }

        // To separate generations
        System.out.println("------------------------------");

        for (int i = 0; i < earthV2.length; i++) {

          for (int j = 0; j < earthV2[i].length; j++) {
            neighborCount = 0; // Reset neighbor count for each cell

            if ((j < earthV2[i].length - 1) && (earthV2[i][j+1] == '.')) {
              neighborCount++;
            }

            if ((i > 0) && (earthV2[i - 1][j] == '.')) {
              neighborCount++;
            }

            if ((i > 0 && j > 0) && (earthV2[i - 1][j - 1] == '.')) {
              neighborCount++;
            }

            if ((i < earthV2.length - 1) && (earthV2[i + 1][j] == '.')) {
              neighborCount++;
            }

            if ((i < earthV2.length - 1) && (j > 0) && (earthV2[i + 1][j - 1] == '.')) {
              neighborCount++;
            }

            if ((i < earthV2.length - 1) && (j < earthV2[i].length - 1) && (earthV2[i + 1][j + 1] == '.')) {
              neighborCount++;
            }

            if ((i > 0) && (j < earthV2[i].length - 1) && (earthV2[i - 1][j + 1] == '.')){
              neighborCount++;
            }

            if ((j > 0) && (earthV2[i][j - 1] == '.')){
              neighborCount++;
            }

            if (neighborCount > 3) {
              newEarthV2[i][j] = ' ';
            } else if (neighborCount == 3 && earthV2[i][j] == ' '){
              newEarthV2[i][j] = '.';
            } else if ((neighborCount == 2 || neighborCount == 3) && earthV2[i][j] == '.') {
              newEarthV2[i][j] = '.';
            } else {
              newEarthV2[i][j] = ' ';
            }
          }
        }

        // Transfer data from newEarth to the original earth
        for (int i = 0; i < newEarthV2.length; i++) {
          for (int j = 0; j < newEarthV2[i].length; j++) {
            earthV2[i][j] = newEarthV2[i][j];
          }
        }

      }while(numberOfIterations != numberOfGenerations);

    }
}
