import java.util.Scanner;


public class Connect4mp
{
	final int SPEED = 50;
   int[][] gameTable = {
                           {0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0}
                        };
   int move = 0;
   int turn = 1;

   public Connect4mp ()
   {
      start();
   }
   
   private void start()
   {
      while ( getWinner() == 4 ) //on going
      {  
         move++;
         clearScreen();
         preview();
         System.out.println("It's player " + ((move%2 == 1)?1:2) + "'s turn!");
         moveAndPreview(readPoint(),(move%2 == 1)?1:2);
      }
      clearScreen();
      preview();
      if (getWinner()<3)
         System.out.println("Player " + getWinner() + " has won the game!");
      else
         System.out.println("It's a tie!");
   }

   private int[] readPoint() //get new move and uptade the table using the letter
   {
      Scanner userInput = new Scanner(System.in);
      System.out.print("Enter the column number: ");
      boolean inputValid = false;
      int[] result = new int[2];
      int column = 0, row = 0;
      while (!inputValid)
      {
         //input check
         if (userInput.hasNextInt()) 
         {
            column = userInput.nextInt() - 1;
            if ((column<=6) && (column>=0) && (gameTable[0][column] == 0))
               inputValid = true;
            else
               {
                  System.out.println("Invalid move!");
                  System.out.print("Enter the column number: ");
                  userInput.nextLine();
               }
         }
         else
         {
            System.out.println("Invalid input");
            System.out.print("Enter the column number: ");
            userInput.nextLine();
         }
      }

      while(gameTable[row][column] == 0)
      {
         row++;
         if (row == 6)
            break;
      }
      row--;
      result[0] = row;
      result[1] = column;
      return result;
   }

   private void moveAndPreview(int[] newMove, int newMoveID)
   {
      String preview =
         "                                                                   \n"+
         "       1        2        3        4        5        6        7     \n"+
         "   ****************************************************************\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   *   " + switch(gameTable[0][0]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][1]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][2]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][3]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][4]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][5]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][6]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *\n"+
         "   *   " + switch(gameTable[0][0]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][1]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][2]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][3]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][4]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][5]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][6]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   ****************************************************************\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   *   " + switch(gameTable[1][0]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][1]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][2]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][3]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][4]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][5]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][6]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *\n"+
         "   *   " + switch(gameTable[1][0]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][1]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][2]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][3]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][4]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][5]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][6]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   ****************************************************************\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   *   " + switch(gameTable[2][0]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][1]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][2]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][3]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][4]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][5]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][6]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *\n"+
         "   *   " + switch(gameTable[2][0]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][1]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][2]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][3]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][4]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][5]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][6]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   ****************************************************************\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   *   " + switch(gameTable[3][0]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][1]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][2]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][3]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][4]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][5]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][6]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *\n"+
         "   *   " + switch(gameTable[3][0]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][1]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][2]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][3]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][4]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][5]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][6]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   ****************************************************************\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   *   " + switch(gameTable[4][0]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][1]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][2]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][3]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][4]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][5]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][6]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *\n"+
         "   *   " + switch(gameTable[4][0]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][1]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][2]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][3]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][4]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][5]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][6]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   ****************************************************************\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   *   " + switch(gameTable[5][0]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][1]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][2]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][3]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][4]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][5]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][6]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *\n"+
         "   *   " + switch(gameTable[5][0]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][1]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][2]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][3]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][4]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][5]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][6]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   ****************************************************************\n";

      int lastLine = newMove[0]*5 + 6, lineNum = 0;
      String currentLine, finalString = "";
      for (int i=1; i<= lastLine; i++)
      {
         Scanner scan = new Scanner(preview);
         while (scan.hasNextLine())
         {
            currentLine = scan.nextLine() + "\n";
            lineNum++;
            if(lineNum == i )
            {
               if (newMoveID == 1)
                  currentLine = currentLine.substring(0,7 + 9 * newMove[1]) + "/\\" + currentLine.substring(9 + 9 * newMove[1]);
               else
                  currentLine = currentLine.substring(0,7 + 9 * newMove[1]) + "\\/" + currentLine.substring(9 + 9 * newMove[1]);
            }
            if(lineNum == (i-1))
            {  
               if (newMoveID == 2)
                  currentLine = currentLine.substring(0,7 + 9 * newMove[1]) + "/\\" + currentLine.substring(9 + 9 * newMove[1]);
               else
                  currentLine = currentLine.substring(0,7 + 9 * newMove[1]) + "\\/" + currentLine.substring(9 + 9 * newMove[1]);
            }
            finalString += currentLine;
         }
         clearScreen();
         System.out.println(finalString);
         finalString = "";
         lineNum = 0;
         try
         {
            Thread.sleep(SPEED);
         }
         catch (Exception  e)
         {
            System.out.println("caught: " + e);
         }

      }
      gameTable[newMove[0]][newMove[1]] = newMoveID;   
   }

   private void preview()
   {
      String preview =
         "                                                                   \n"+
         "       1        2        3        4        5        6        7     \n"+
         "   ****************************************************************\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   *   " + switch(gameTable[0][0]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][1]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][2]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][3]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][4]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][5]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][6]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *\n"+
         "   *   " + switch(gameTable[0][0]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][1]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][2]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][3]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][4]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][5]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[0][6]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   ****************************************************************\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   *   " + switch(gameTable[1][0]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][1]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][2]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][3]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][4]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][5]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][6]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *\n"+
         "   *   " + switch(gameTable[1][0]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][1]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][2]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][3]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][4]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][5]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[1][6]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   ****************************************************************\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   *   " + switch(gameTable[2][0]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][1]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][2]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][3]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][4]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][5]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][6]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *\n"+
         "   *   " + switch(gameTable[2][0]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][1]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][2]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][3]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][4]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][5]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[2][6]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   ****************************************************************\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   *   " + switch(gameTable[3][0]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][1]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][2]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][3]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][4]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][5]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][6]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *\n"+
         "   *   " + switch(gameTable[3][0]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][1]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][2]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][3]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][4]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][5]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[3][6]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   ****************************************************************\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   *   " + switch(gameTable[4][0]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][1]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][2]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][3]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][4]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][5]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][6]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *\n"+
         "   *   " + switch(gameTable[4][0]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][1]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][2]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][3]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][4]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][5]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[4][6]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   ****************************************************************\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   *   " + switch(gameTable[5][0]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][1]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][2]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][3]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][4]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][5]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][6]){case 1->"\\/"; case 2->"/\\"; default->"  ";} + "   *\n"+
         "   *   " + switch(gameTable[5][0]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][1]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][2]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][3]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][4]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][5]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *   " + switch(gameTable[5][6]){case 2->"\\/"; case 1->"/\\"; default->"  ";} + "   *\n"+
         "   *        *        *        *        *        *        *        *\n"+
         "   ****************************************************************\n";

      System.out.println(preview);
   }

   private int getWinner() // 1,2:player number 3:tie 4:on going
   {
      // column
      for (int i=0; i<=2; i++)
      {
         for (int j=0; j<=6; j++)
         {
            if ((gameTable[i][j] == gameTable[i+1][j]) && (gameTable[i][j] == gameTable[i+2][j]) && (gameTable[i][j] == gameTable[i+3][j]))
            {
               if (gameTable[i][j] == 1)
                  return 1;
               if (gameTable[i][j] == 2)
                  return 2;
            }
         }  
      }

      // row
      for (int i=0; i<=5; i++)
      {
         for (int j=0; j<=3; j++)
         {
            if ((gameTable[i][j] == gameTable[i][j+1]) && (gameTable[i][j] == gameTable[i][j+2]) && (gameTable[i][j] == gameTable[i][j+3]))
            {
               if (gameTable[i][j] == 1)
                  return 1;
               if (gameTable[i][j] == 2)
                  return 2;
            }
         }  
      }

      // \
      for (int i=0; i<=2; i++)
      {
         for (int j=0; j<=3; j++)
         {
            if ((gameTable[i][j] == gameTable[i+1][j+1]) && (gameTable[i][j] == gameTable[i+2][j+2]) && (gameTable[i][j] == gameTable[i+3][j+3]))
            {
               if (gameTable[i][j] == 1)
                  return 1;
               if (gameTable[i][j] == 2)
                  return 2;
            }
         }  
      }
      // /
      for (int i=0; i<=2; i++)
      {
         for (int j=3; j<=6; j++)
         {
            if ((gameTable[i][j] == gameTable[i+1][j-1]) && (gameTable[i][j] == gameTable[i+2][j-2]) && (gameTable[i][j] == gameTable[i+3][j-3]))
            {
               if (gameTable[i][j] == 1)
                  return 1;
               if (gameTable[i][j] == 2)
                  return 2;
            }
         }  
      }
      //no winners
      if (move < 42)
         return 4;
      else
         return 3;
   }

   private void clearScreen() 
   {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
   }
}
