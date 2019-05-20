//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack
{
  //add in Player instance variable
  private Player player;
  //add in Dealer instance variable
  private Dealer dealer;

  private boolean play;
  private boolean hit;
  private int dScore;
  private int pScore;

  public BlackJack()
  {
    player = new Player();
    dealer = new Dealer();
    play = true;
    hit = true;
    dScore = 0;
    pScore = 0;
  }

  public void playGame()
  {
    Scanner keyboard = new Scanner(System.in);
    char choice;

    while(play)
    {
      dealer.shuffle();
      player.resetHand();
      dealer.resetHand();
      hit = true;

      player.addCardToHand(dealer.deal());
      player.addCardToHand(dealer.deal());
      dealer.addCardToHand(dealer.deal());
      dealer.addCardToHand(dealer.deal());

      System.out.println("Player " + player);
      System.out.println("Hand Value: " + player.getHandValue());

      while(player.getHandValue()<=21 && hit)
      {
        System.out.println("HIT? y/n");
        choice = keyboard.next().charAt(0);
        if(choice == 'y')
          player.addCardToHand(dealer.deal());
        else
          hit = false;

        System.out.println("\n PLAYER");
        System.out.println("Hand Value: " + player.getHandValue());
        System.out.println("Hand Size: " + player.getHandSize());
        System.out.println(player);
      }

      while(dealer.getHandValue()<=(21-(int)Math.random()*5))
      {
        dealer.addCardToHand(dealer.deal());
      }
      System.out.println("\n DEALER");
      System.out.println("Hand Value: " + dealer.getHandValue());
      System.out.println("Hand Size: " + dealer.getHandSize());
      System.out.println(dealer);

      if (player.getHandValue() > 21 && dealer.getHandValue() > 21)
      {
        System.out.println("\n Both Busted!");
      }
      else if (player.getHandValue() > 21 && dealer.getHandValue() <= 21)
      {
        dScore++;
        dealer.setWinCount(dScore);

        System.out.println("\n You Busted and Dealer has bigger hand value!");
      }
      else if (player.getHandValue() <= 21 && dealer.getHandValue() > 21)
      {
        pScore++;
        player.setWinCount(pScore);

        System.out.println("\n Dealer Busted and Player has bigger hand value!");
      }
      else
      {
        if (player.getHandValue() > dealer.getHandValue())
        {
          pScore++;
          player.setWinCount(pScore);

          System.out.println("\n Player has bigger hand value!");
        }
        else if (player.getHandValue() < dealer.getHandValue())
        {
          dScore++;
          dealer.setWinCount(dScore);

          System.out.println("\n Dealer has bigger hand value!");
        }
        else 
        {
          System.out.println("\n It's a tie!");
        }
      }

      System.out.println("\n Dealer has won " + dScore + " times.");
      System.out.println("\n Player has won " + pScore + " times.");

      System.out.println("\n Do you want to play again? y/n ");
      char answer = keyboard.next().charAt(0);

      if (answer == 'n')
      {
        play = false;
      }
    }
  }
        
  public static void main(String[] args)
  {
    BlackJack game = new BlackJack();
    game.playGame();
  }
}